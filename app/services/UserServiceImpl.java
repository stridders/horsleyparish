package services;

import com.google.inject.Inject;
import model.User;
import security.OAuthCredentials;
import model.UserRole;
import play.Logger;
import play.api.Play;
import play.db.jpa.JPAApi;
import security.model.UserProfile;
import services.transformers.UserTransformer;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
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

    /**
     * Returns a User POJO for a given user email address
     * @param email
     * @return
     */
    public User getUser(String email) {
        logger.debug("Entered getUser");
        TypedQuery<User> query = em().createNamedQuery("User.findByEmail", User.class);
        User user = query.getSingleResult();
        return user;
    }

    /**
     * Authenticates username/password credentials.
     * Returns a UserProfile object if user is authenticated, else returns null.
     * @param OAuthCredentials
     * @return
     */
    @Override
    public UserProfile authenticateUser(OAuthCredentials OAuthCredentials) {
        logger.debug("Authenticating user credentials");
        TypedQuery<User> query = em().createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", OAuthCredentials.getEmail());
        try {
            User validatedUser = query.getSingleResult();
            if (validatedUser.getPassword().equals(OAuthCredentials.getPassword())) {
                logger.debug(VALID_PASSWORD);
                List<String> roles = getUserRoles(validatedUser);
                UserProfile userProfile = new UserProfile(validatedUser);
                userProfile.setRoles(roles);
                return userProfile;
            } else {
                logger.info(INVALID_PASSWORD);
                return null;
            }
        } catch (NoResultException nre) {
            logger.info(String.format(NO_MATCH, OAuthCredentials.getEmail()));
            return null;
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


}
