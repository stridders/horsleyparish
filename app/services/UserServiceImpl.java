package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import model.User;
import model.UserRole;
import play.Logger;
import play.api.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
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
        logger.debug("Entered authenticateUser: "+userCredentials);
        User authUser = UserTransformer.transformJsonToUserPOJO(userCredentials);
        TypedQuery<User> query = em().createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email",authUser.getEmail());
        try {
            User validatedUser = query.getSingleResult();
            List<String> roles = getUserRoles(validatedUser);
            return userTransformer.authoriseUser(validatedUser,roles);
        } catch (NoResultException nre) {
            return userTransformer.invalidateUser(userCredentials);
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
