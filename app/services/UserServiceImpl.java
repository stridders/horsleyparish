package services;

import com.google.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserServiceImpl implements UserService {

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Override
    public void getUsers(String surname, String firstName, String email) {

    }


    private EntityManager getEntityManager() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return (em);
    }
}
