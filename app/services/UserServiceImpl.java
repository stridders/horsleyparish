package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import model.User;
import model.UserCredentialsJson;
import model.UserRole;
import play.Logger;
import play.api.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import security.model.UserProfile;
import services.transformers.UserTransformer;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService {

    @Inject
    UserTransformer userTransformer;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    private static final String NO_MATCH = "Unrecognised User [%s]";
    private static final String INVALID_PASSWORD = "User password invalid";
    private static final String VALID_PASSWORD = "User password validated";
    private static final String INVALID_CREDENTIALS = "Invalid user credentials";

    /**
     * Returns a list of users (from the 'people' table), optionally filtered by
     * surname, firstname and/or email
     * @param surname
     * @param firstName
     * @param email
     * @return
     */
    @Override
    public List<User> getUsers(String surname, String firstName, String email) {
        logger.debug("Entered getUsers");
        TypedQuery<User> query = em().createNamedQuery("User.findAll", User.class);
        List<User> users = query.getResultList();
        return users
                .stream().filter(user -> {
                    Boolean match = true;
                    if (surname != null && !user.getSurname().toLowerCase().equals(surname.toLowerCase())) {
                        match = false;
                    }
                    if (firstName != null && !user.getFirstname().toLowerCase().equals(firstName.toLowerCase())) {
                        match = false;
                    }
                    if (email != null && !user.getEmail().toLowerCase().equals(email.toLowerCase())) {
                        match = false;
                    }
                    return match;
                })
                .collect(Collectors.toList());
    }


    @Override
    public String authenticateUser(JsonNode userCredentials) {
        User inputCredentials = UserTransformer.transformJsonToUserPOJO(userCredentials);
        TypedQuery<User> query = em().createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email",inputCredentials.getEmail());
        try {
            User validatedUser = query.getSingleResult();
            if (validatedUser.getPassword().equals(inputCredentials.getPassword())) {
                List<String> roles = getUserRoles(validatedUser);
                return userTransformer.authoriseUser(validatedUser,roles);
            } else {
                return userTransformer.invalidateUser(userCredentials,INVALID_CREDENTIALS);
            }
        } catch (NoResultException nre) {
            return userTransformer.invalidateUser(userCredentials,INVALID_CREDENTIALS);
        }
    }

    @Override
    public UserProfile authenticateUser(UserCredentialsJson userCredentialsJson) {
        logger.debug("Authenticating user credentials");
        TypedQuery<User> query = em().createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email",userCredentialsJson.getEmail());
        try {
            User validatedUser = query.getSingleResult();
            if (validatedUser.getPassword().equals(userCredentialsJson.getPassword())) {
                logger.debug(VALID_PASSWORD);
                List<String> roles = getUserRoles(validatedUser);
                UserProfile userProfile = new UserProfile(validatedUser);
                userProfile.setRoles(roles);
                return userProfile;
            } else {
                logger.info(INVALID_PASSWORD);
                return new UserProfile();
            }
        } catch (NoResultException nre) {
            logger.info(String.format(NO_MATCH,userCredentialsJson.getEmail()));
            return new UserProfile();
        }
    }

    /**
     * Returns a list of roles for a given userId
     * @param user
     * @return
     */
    @Override
    public List<String> getUserRoles(User user) {
        TypedQuery<UserRole> query = em().createNamedQuery("UserRole.findUserRoles", UserRole.class);
        query.setParameter("userId",user.getUser_id());
        List<UserRole> userRoles = query.getResultList();
        return userRoles.stream()
                .map(ur -> {
                    return ur.getRole().getRole();
                })
                .collect(Collectors.toList());
    }


    private static EntityManager em() {
        JPAApi jpaApi = Play.current().injector().instanceOf(JPAApi.class);
        EntityManager em = jpaApi.em();
        em.setFlushMode(FlushModeType.COMMIT);
        return (em);
    }

//    private static EntityManager em() {
//        EntityManager em = JPA.em();
//        em.setFlushMode(FlushModeType.COMMIT);
//        return (em);
//    }



}
