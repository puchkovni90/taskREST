package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private Logger LOGGER;
    private SessionFactory sessionFactory;
    private String hibernateCfgPath;

    //TODO: inject if using DI
    private String dbUsername;
    private String dbPassword;

    public HibernateSessionFactoryUtil() {
        //TODO: comment if using DI
        this("postgres", "postgres");

        init();
    }

    public HibernateSessionFactoryUtil(String dbUsername, String dbPassword) {
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;

        init();
    }

    private void init() {
        LOGGER = Logger.getLogger(HibernateSessionFactoryUtil.class);
        LOGGER.debug("Creating hibernate session factory util");

        hibernateCfgPath = "hibernate.cfg.xml";
        try {
            Configuration cfg = new Configuration().configure(hibernateCfgPath);
            cfg.setProperty("connection.username", this.dbUsername);
            cfg.setProperty("connection.password", this.dbPassword);
            sessionFactory = cfg.buildSessionFactory();
            LOGGER.debug("Successfully configured SessionFactory");
        } catch (HibernateException e) {
            LOGGER.error("Error while creating sessionFactory. Config used: " + hibernateCfgPath + "; database username: " + dbUsername + "; password: " + dbPassword);
            LOGGER.error(e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        LOGGER.debug("Closing sessionFactory.");
        sessionFactory.close();
    }

    //todo: {@link http://javastudy.ru/hibernate/hibernate-quick-start/}
}
