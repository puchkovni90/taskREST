package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO;

import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import java.util.List;

/**
 * DAO interface for model class {@link ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User}
 */
public interface UserDAO {
    User getUser(Integer id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Integer id);
    List<User> getUsers();
}
