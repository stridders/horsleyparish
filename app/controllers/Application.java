package controllers;

import play.Configuration;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import com.google.inject.Inject;
import security.model.UserProfile;
import views.html.index;

import javax.inject.Named;

/**
 * Created by jstride on 06/10/2016.
 */
public class Application extends Controller {

//    @Inject
//    @Named("app.version")
//    String appVersion;

    @Inject
    Configuration configuration;

    @Inject
    WebJarAssets webJarAssets;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    public Result index() {
        UserProfile userProfile = new UserProfile();
        return ok(index.render(webJarAssets,userProfile));
    }

    public Result version() {
        return ok("Horsley Parish (Gloucestershire) Website.  Build version: ");
    }

    public Result redirect() {
        return redirect("/web");
    }

    public Result anything(String stuff) {
        if (stuff.equals("")) {
            return movedPermanently(request().path() + "web");
        }
        UserProfile userProfile = new UserProfile();
        return notFound(views.html.notFoundPage.render(webJarAssets, stuff, userProfile));
    }

    public Result untrail(String path) {
        String newPath = request().path().replaceAll("/$", "");
        return movedPermanently(newPath);
    }

}
