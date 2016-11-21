package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import org.apache.commons.lang3.ArrayUtils;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import security.model.UserProfile;
import services.UserService;
import services.transformers.UserTransformer;

import java.util.List;

import static play.mvc.Controller.request;
import static play.mvc.Results.forbidden;
import static play.mvc.Results.ok;
import static play.mvc.Results.unauthorized;

/**
 * Created by js on 08/11/2016.
 */
public class User {

    @Inject
    private UserService userService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Transactional
    @Security.Authenticated(UserAuthenticator.class)
    @RoleBasedAuthoriser.RolesAllowed(RoleBasedAuthoriser.Roles.ADMIN)
    public Result listUsers(String surname, String firstname, String email) {
        List<model.User> users = userService.getUsers(surname, firstname, email);
        String jsonRep = UserTransformer.transformUserListToHalJson(users,surname,firstname,email);
        return ok(jsonRep).as("application/hal+json");
    }

    @Transactional
    @Security.Authenticated(UserAuthenticator.class)
    public Result authenticate() {
        UserProfile userProfile = null;
        Http.Context context = Http.Context.current();
        String profile = context.session().get(UserAuthenticator.USER_PROFILE_KEY);
        if (profile != null) {
            userProfile = Json.fromJson(Json.parse(profile), UserProfile.class);
        }
        if (userProfile == null) {
            return unauthorized();
        } else {
            return ok(userProfile.toString()).as("application/hal+json");
        }
    }
}
