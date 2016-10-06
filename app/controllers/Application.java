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

    @Inject
    @Named("app.version")
    String appVersion;

    @Inject
    Configuration configuration;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    public static Result index() {
        UserProfile userProfile = new UserProfile("Jon", "Stride", "email@jonstride.uk", "A000001");
        return ok(index.render(userProfile));
    }

    public static Result version() {
        return ok("Horsley Parish (Gloucestershire) Website.  Build version: ");
    }

    public static Result redirect() {
        return redirect("/pages");
    }

}
