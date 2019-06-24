package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Created by jstride on 06/10/2016.
 */
public class Application extends Controller {


    public Result index() {
        return ok(index.render());
    }

    public Result version() {
        return ok("Horsley Parish (Gloucestershire) Website.  Build version: ");
    }

    public Result redirect() {
        return redirect("/glos");
    }

    public Result anything(String stuff) {
        if (stuff.equals("")) {
            return movedPermanently(request().path() + "glos");
        }
        return notFound(views.html.notFoundPage.render());
    }

    public Result untrail(String path) {
        String newPath = request().path().replaceAll("/$", "");
        return movedPermanently(newPath);
    }

}
