package br.com.confitecsp.java.web.bean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaResourceBean {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("incidente");
        }
        return entityManagerFactory;
    }
}
