package controllers;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import play.mvc.Result;

import java.util.UUID;

import static play.mvc.Results.ok;

/**
 * Created by js on 08/11/2016.
 */
public class User {

    public Result findUsers(String surname, String firstname, String email) {
        String uuid = UUID.randomUUID().toString();
        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation serviceLinks = rf.newRepresentation();

        serviceLinks.withLink("self", Root.stripApiContext(routes.UuidGenerator.randomUUID().url()));
        serviceLinks.withProperty("uuid",uuid);

        return ok(serviceLinks.toString(RepresentationFactory.HAL_JSON)).as("application/hal+json");
    }
}
