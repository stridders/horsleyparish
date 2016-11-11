package services;

import com.fasterxml.jackson.databind.JsonNode;
import model.User;
import model.UserRole;
import play.Logger;

import java.util.List;

public interface UserService {

    List<User> getUsers(String surname, String firstName, String email);

    String authenticateUser(JsonNode userCredentials);

    List<String> getUserRoles(User user);

}
