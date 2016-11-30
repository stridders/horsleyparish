package security.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.apache.commons.lang3.StringUtils;
import play.mvc.Http;
import security.UserAuthenticator;

import java.io.IOException;
import java.util.List;

/**
 * Created by js on 23/06/2016.
 */
public class UserProfile {

    private static final String UNKNOWN = "UNKNOWN";

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("userid")
    private Long userid;

    @JsonProperty("roles")
    private List<String> roles;

    @JsonCreator
    public UserProfile() {}

    public UserProfile(User user) {
        this.setFirstName(user.getFirstname());
        this.setSurname(user.getSurname());
        this.setEmail(user.getEmail());
        this.setUserid(user.getUser_id());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean hasRole(String role) {
        return this.roles.contains(role);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch(IOException ioe) {
            return null;
        }
    }

    /**
     * Returns the UserProfile stored in the current HTTP context session (if present)
     * @return
     */
    public static UserProfile getUserProfileFromHttpContext() {
        Http.Context context = Http.Context.current();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode json = objectMapper.readTree(context.session().get(UserAuthenticator.USER_PROFILE_KEY));
            return transformFrom(json);
        } catch (IOException ioe) {
            return null;
        }
    }

    public static String getUserIP() {
        String ipAddress = Http.Context.current().request().remoteAddress();
        return StringUtils.isBlank(ipAddress) ? UNKNOWN : ipAddress;
    }

    /**
     * Converts a JSON node into a UserProfile POJO
     * @param json
     * @return
     */
    public static UserProfile transformFrom(JsonNode json) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(json.findPath("email").asText());
        userProfile.setSurname(json.findPath("surname").asText());
        userProfile.setFirstName(json.findPath("firstname").asText());
        userProfile.setUserid(json.findPath("userId").asLong());
        userProfile.setRoles(json.findValuesAsText("roles"));
        return userProfile;
    }

}
