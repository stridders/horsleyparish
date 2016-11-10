package services;

import com.google.inject.Inject;
import model.User;
import play.Logger;
import play.api.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    /**
     * Returns a list of users (from people table), optionally filtered by surname, firstname and/or email
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


//    private static EntityManager em() {
//        JPAApi jpaApi = Play.current().injector().instanceOf(JPAApi.class);
//        EntityManager em = jpaApi.em();
//        em.setFlushMode(FlushModeType.COMMIT);
//        return (em);
//    }

    private static EntityManager em() {
        EntityManager em = JPA.em();
        em.setFlushMode(FlushModeType.COMMIT);
        return (em);
    }

}
