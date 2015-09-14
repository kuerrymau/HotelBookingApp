package com.crimore.entitymanager;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by cchingwenje on 2015-09-13.
 */

public class EntityManagerImpl {
    private static final EntityManagerFactory entityManagerFactory;
    static Logger log = Logger.getLogger(EntityManagerImpl.class);

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("booking");

        } catch (Throwable ex) {
            log.error("SessionFactory  initialisation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
