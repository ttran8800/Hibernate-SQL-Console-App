package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateFactory {
    private static SessionFactory sessionFactory = null;

    private HibernateFactory() {

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                config.configure("hibernate.cfg.xml");
                sessionFactory = config.buildSessionFactory();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
