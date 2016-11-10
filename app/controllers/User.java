package controllers;

import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;
import services.UserService;
import services.transformers.UserTransformer;

import java.util.List;

import static play.mvc.Results.ok;

/**
 * Created by js on 08/11/2016.
 */
public class User {

    @Inject
    private UserService userService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Transactional
    public Result listUsers(String surname, String firstname, String email) {
        List<model.User> users = userService.getUsers(surname, firstname, email);
        String jsonRep = UserTransformer.transformUserListToHalJson(users,surname,firstname,email);
        return ok(jsonRep).as("application/hal+json");
    }

}
