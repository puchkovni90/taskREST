package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO;

import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import java.util.*;

public class UserDAONoDBImpl implements UserDAO {
    private Map<Integer, User> users;

    public UserDAONoDBImpl() {
        initUsers();
    }

    private void initUsers() {
        users = new HashMap<Integer, User>();
        for (int i = 1; i < 15; i++) {
            users.put(Integer.valueOf(i), new User(Integer.valueOf(i), "user"+i, "password"+i));
        }
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }

    @Override
    public boolean addUser(User user) {
        if (users.containsKey(user.getId()))
            return false;

        users.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if (!users.containsKey(user.getId()))
            return false;

        users.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (!users.containsKey(id))
            return false;

        users.remove(id);
        return true;
    }

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<User>();
        result.addAll(users.values());
        return result;
    }
}
