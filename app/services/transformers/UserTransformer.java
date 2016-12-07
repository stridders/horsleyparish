package services.transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import controllers.Root;
import dto.HrefDto;
import dto.AuthenticatedUserDto;
import model.User;

import java.io.StringWriter;
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

        rep.withProperty("users", users);
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

    /**
     * Returns an Authentication response (JSON) with an Invalid User notification
     * @param json
     * @param reason
     * @return
     */
    public static String invalidateUser(JsonNode json, String reason) {
        AuthenticatedUserDto dto = new AuthenticatedUserDto();
        HrefDto href = new HrefDto(Root.stripApiContext(controllers.routes.User.authenticate().url()));
        dto.get_links().setSelf(href);
        dto.setAuthenticated(false);
        dto.setReason(reason);
        dto.setCredentials(json.asText());
        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();
    }

    public static String authoriseUser(User user, List<String> roles) {
        AuthenticatedUserDto dto = new AuthenticatedUserDto();
        HrefDto href = new HrefDto(Root.stripApiContext(controllers.routes.User.authenticate().url()));
        dto.get_links().setSelf(href);
        dto.setAuthenticated(true);
        dto.setCredentials(user.getEmail());
        dto.setRoles(roles);
        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();

    }
}
