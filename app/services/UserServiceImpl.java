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


public class UserServiceImpl implements UserService {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Override
    public List<User> getUsers(String surname, String firstName, String email) {
        TypedQuery<User> query = em().createNamedQuery("User.findBySurname", User.class);
        query.setParameter("surname", surname);
        return query.getResultList();
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
