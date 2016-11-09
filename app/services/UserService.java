package services;

import model.User;
import play.Logger;

import java.util.List;

public interface UserService {

    List<User> getUsers(String surname, String firstName, String email);
}
