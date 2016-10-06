package controllers;

import com.theoryinpractise.halbuilder.api.*;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import play.mvc.Controller;
import play.mvc.Result;

import static play.mvc.Results.ok;

/**
 * Created by js on 17/08/2016.
 */
public class Root extends Controller {

    public Result apiRoot() {
        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation serviceLinks = rf.newRepresentation();

        serviceLinks.withLink("self", "/");

        return ok(serviceLinks.toString(RepresentationFactory.HAL_JSON));
    }
}
