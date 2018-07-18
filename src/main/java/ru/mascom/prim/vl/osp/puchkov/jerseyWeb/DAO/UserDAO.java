package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO;

import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import java.util.List;

public interface UserDAO {
    User getUser(Integer id);
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(Integer id);
    List<User> getUsers();
}
