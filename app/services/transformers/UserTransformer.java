package services.transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import controllers.Root;
import controllers.routes;
import model.User;
import model.UserJson;
import play.Logger;
import services.UserService;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by js on 09/11/2016.
 */
public class UserTransformer {

    /**
     * Converts a User POJO into a HAL-JSON representation
     * @param users
     * @param surname
     * @param firstname
     * @param email
     * @return
     */
    public static String transformUserListToHalJson (List<User> users,
                                                     String surname,
                                                     String firstname,
                                                     String email) {

        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation rep = rf.newRepresentation();

        rep.withLink("self", Root.stripApiContext(controllers.routes.User.listUsers(surname,firstname,email).url()));

        List<UserJson> userJsonList = new ArrayList<>();
        users.forEach(user -> {
            userJsonList.add(new UserJson(user));
        });
        rep.withProperty("users", userJsonList);
        StringWriter sw = new StringWriter();
        rep.toString(RepresentationFactory.HAL_JSON,sw);
        return sw.toString();
    }

    /**
     * Converts a JSON node into a User POJO
     * @param json
     * @return
     */
    public static User transformJsonToUserPOJO(JsonNode json) {
        User user = new User();
        user.setEmail(json.findPath("email").asText());
        user.setSurname(json.findPath("surname").asText());
        user.setFirstname(json.findPath("firstname").asText());
        user.setPassword(json.findPath("password").asText());
        user.setUser_id(json.findPath("userId").asLong());
        return user;
    }

    public static String invalidateUser(JsonNode json) {
        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation rep = rf.newRepresentation();

        rep.withLink("self", Root.stripApiContext(controllers.routes.User.authenticate().url()));
        rep.withProperty("authenticated", false);
        rep.withProperty("userCredentials",json);
        StringWriter sw = new StringWriter();
        rep.toString(RepresentationFactory.HAL_JSON,sw);
        return sw.toString();
    }

    public static String authoriseUser(User user, List<String> roles) {
        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation rep = rf.newRepresentation();

        rep.withLink("self", Root.stripApiContext(controllers.routes.User.authenticate().url()));
        rep.withProperty("authenticated", true);
        rep.withProperty("userCredentials",new UserJson(user));
        rep.withProperty("roles",roles);
        StringWriter sw = new StringWriter();
        rep.toString(RepresentationFactory.HAL_JSON,sw);
        return sw.toString();
    }
}
