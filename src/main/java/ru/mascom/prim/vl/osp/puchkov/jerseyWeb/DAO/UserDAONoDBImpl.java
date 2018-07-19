package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO;

import org.apache.log4j.Logger;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import java.util.*;

/**
 * {@link ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAO} dummy
 */
public class UserDAONoDBImpl implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAONoDBImpl.class);
    private Map<Integer, User> users;

    public UserDAONoDBImpl() {
        LOGGER.debug("Creating no-database UserDAO dummy");
        initUsers();
    }

    private void initUsers() {
        users = new HashMap<Integer, User>();
        int recordsCount = 15;
        for (int i = 0; i < recordsCount; i++) {
            users.put(Integer.valueOf(i), new User(Integer.valueOf(i), "user"+i, "password"+i));
        }
        LOGGER.debug("Successfully filled no-database UserDAO dummy by " + recordsCount + " user records");
    }

    @Override
    public User getUser(Integer id) {
        User result = users.get(id);
        LOGGER.debug("Successfully got a user fromDAO by id.");
        return result;
    }

    @Override
    public boolean addUser(User user) {
        if (users.containsKey(user.getId())) {
            LOGGER.info("Can't add a user: DAO contains a user with such id. Adding: " + user.toString() + " Contained: " + users.get(user.getId()));
            return false;
        }

        users.put(user.getId(), user);
        LOGGER.debug("Successfully added new user to DAO: " + user.toString());
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if (!users.containsKey(user.getId())) {
            LOGGER.info("Can't update a user: DAO does not contain user with such id: " + user.getId());
            return false;
        }

        users.put(user.getId(), user);
        LOGGER.debug("Successfully updated a user");
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (!users.containsKey(id)) {
            LOGGER.info("Can't delete a user with such id, not found in DAO. id: " + id);
            return false;
        }

        users.remove(id);
        LOGGER.debug("Successfully deleted a user, id: " + id);
        return true;
    }

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<User>();
        result.addAll(users.values());
        LOGGER.debug("Getting list of users.");
        return result;
    }
}
