package security.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import play.mvc.Http;
import security.UserAuthenticator;

import java.util.List;

/**
 * Created by js on 23/06/2016.
 */
public class UserProfile {

    private static final long serialVersionUID = 1L;

    private static final String UNKNOWN = "UNKNOWN";

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("userid")
    private String userid;

    @JsonProperty("roles")
    private List<String> roles;

    @JsonCreator
    public UserProfile() {}

    public UserProfile(String firstName,
                       String surname,
                       String email,
                       String userid) {
        this.setFirstName(firstName);
        this.setSurname(surname);
        this.setEmail(email);
        this.setUserid(userid);
    }

    @JsonCreator
    public UserProfile(String firstName,
                       String surname,
                       String email,
                       String userid,
                       List<String> roles) {
        this.setFirstName(firstName);
        this.setSurname(surname);
        this.setEmail(email);
        this.setUserid(userid);
        this.setRoles(roles);
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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
        return "UserProfile {" +
                    "firstName='" + firstName + "'," +
                    "surname='" + surname + "'," +
                    "email='" + email + "'," +
                    "userid='" + userid + "'" +
                    "roles=" + roles +
                '}';
    }

    public static UserProfile getUserProfileFromHttpContext() {
        Http.Context context = Http.Context.current();
        return (UserProfile) context.args.get(UserAuthenticator.USER_PROFILE_KEY);
    }

    public static String getUserIP() {
        String ipAddress = Http.Context.current().request().remoteAddress();
        return StringUtils.isBlank(ipAddress) ? UNKNOWN : ipAddress;
    }

}
