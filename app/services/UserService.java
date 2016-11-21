package services;

import model.User;
import security.OAuthCredentials;
import security.model.UserProfile;

import java.util.List;

public interface UserService {

    List<User> getUsers(String surname, String firstName, String email);

    UserProfile authenticateUser(OAuthCredentials OAuthCredentials);

    List<String> getUserRoles(User user);

}
