package services;

import model.User;
import security.OAuthCredentials;
import security.model.UserProfile;

import java.util.List;

public interface UserService {

    /**
     * Returns a list of users (from the 'people' table), optionally filtered by
     * surname, firstname and/or email
     * @param surname
     * @param firstName
     * @param email
     * @return
     */
    List<User> getUsers(String surname, String firstName, String email);

    /**
     * Returns a User POJO for a given user email address
     * @param email
     * @return
     */
    User getUser(String email);

    /**
     * Authenticates username/password credentials.
     * Returns a UserProfile object if user is authenticated, else returns null.
     * @param OAuthCredentials
     * @return
     */
    UserProfile authenticateUser(OAuthCredentials OAuthCredentials);

    /**
     * Returns a list of roles for a given userId
     * @param user
     * @return
     */
    List<String> getUserRoles(User user);

}
