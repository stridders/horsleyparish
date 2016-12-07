package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import static play.mvc.Results.ok;

/**
 * Created by js on 17/08/2016.
 */
public class Root {

//    public Result apiRoot() {
//        return ok();
//    }

    public static String stripApiContext(String uri) {
        int index = uri.indexOf("/api/",1);
        if (index == -1) {
            index = 0;
        }
        final String uriWithoutRootContext = uri.substring(index);
        if (!uriWithoutRootContext.startsWith("/")) {
            return "/"+uriWithoutRootContext;
        }
        return uriWithoutRootContext;
    }
}
