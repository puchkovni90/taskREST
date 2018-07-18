package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.service;

import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAO;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAONoDBImpl;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserService {
    private UserDAO userDAO;
    public UserService() {
        //TODO: change to DB DAO if added
        userDAO = new UserDAONoDBImpl();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

}
