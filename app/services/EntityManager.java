package services;

import play.api.Play;
import play.db.jpa.JPAApi;

import javax.persistence.FlushModeType;

/**
 * Created by js on 19/12/2016.
 */
public class EntityManager {

    public static javax.persistence.EntityManager em() {
        JPAApi jpaApi = Play.current().injector().instanceOf(JPAApi.class);
        javax.persistence.EntityManager em = jpaApi.em();
        em.setFlushMode(FlushModeType.COMMIT);
        return (em);
    }

}
