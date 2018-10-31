package com.dmitrii.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            serviceRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata()
                .buildSessionFactory();
        } catch (Throwable th) {
            LOGGER.error("Initial SessionFactory creation failed", th);
            if (serviceRegistry != null) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
