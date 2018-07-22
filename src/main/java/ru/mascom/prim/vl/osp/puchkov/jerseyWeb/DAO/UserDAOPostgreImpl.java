package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import java.util.List;

public class UserDAOPostgreImpl implements UserDAO {
    private Logger LOGGER;
    private final HibernateSessionFactoryUtil sessionUtil;

    public UserDAOPostgreImpl() {
        LOGGER = Logger.getLogger(UserDAOPostgreImpl.class);
        LOGGER.debug("Creating UserDAOPostgreImpl instance.");

        sessionUtil = new HibernateSessionFactoryUtil();
    }

    @Override
    public User getUser(Integer id) {
        LOGGER.debug("Getting user by id from DB.");
        User result = null;
        Session session = null;
        try {
            session = sessionUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = (User) session.get(User.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("Error while getting user by id from DB.");
            LOGGER.error(e.getMessage());
            LOGGER.debug(e.getStackTrace());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public boolean addUser(User user) {
        LOGGER.debug("Adding user to DB.");
        Session session = null;
        boolean result = true;
        synchronized (sessionUtil) {
            try {
                session = sessionUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                LOGGER.error("Error while adding user to DB.");
                LOGGER.error(e.getMessage());
                LOGGER.debug(e.getStackTrace());
                result = false;
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        LOGGER.debug("Updating user in DB.");
        Session session = null;
        boolean result = true;
        synchronized (sessionUtil) {
            try {
                session = sessionUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                LOGGER.error("Error while updating user to DB.");
                LOGGER.error(e.getMessage());
                LOGGER.debug(e.getStackTrace());
                result = false;
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;
    }

    @Override
    public boolean deleteUser(Integer id) {
        LOGGER.debug("Deleting user from DB.");
        Session session = null;
        boolean result = true;
        synchronized (sessionUtil) {
            try {
                session = sessionUtil.getSessionFactory().openSession();
                session.beginTransaction();
                User user = session.get(User.class, id);
                session.delete(user);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                LOGGER.error("Error while deleting user from DB.");
                LOGGER.error(e.getMessage());
                LOGGER.debug(e.getStackTrace());
                result = false;
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;
    }

    @Override
    public List<User> getUsers() {
        LOGGER.debug("Getting user list from DB.");
        List<User> result = null;
        Session session = null;
        try {
            session = sessionUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = (List<User>) session.createCriteria(User.class).list();
        } catch (HibernateException e) {
            LOGGER.error("Error while getting user by id from DB.");
            LOGGER.error(e.getMessage());
            LOGGER.debug(e.getStackTrace());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}
