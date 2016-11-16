package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Security;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import services.UserService;
import services.transformers.UserTransformer;

import java.util.List;

import static play.mvc.Controller.request;
import static play.mvc.Results.ok;

/**
 * Created by js on 08/11/2016.
 */
public class User {

    @Inject
    private UserService userService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Security.Authenticated(UserAuthenticator.class)
    @RoleBasedAuthoriser.RolesAllowed(RoleBasedAuthoriser.Roles.ADMIN)
    @Transactional
    public Result listUsers(String surname, String firstname, String email) {
        List<model.User> users = userService.getUsers(surname, firstname, email);
        String jsonRep = UserTransformer.transformUserListToHalJson(users,surname,firstname,email);
        return ok(jsonRep).as("application/hal+json");
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result authenticate() {
        JsonNode userCredentials = request().body().asJson();
        String jsonRep = userService.authenticateUser(userCredentials);
        return ok(jsonRep).as("application/hal+json");
    }

}
