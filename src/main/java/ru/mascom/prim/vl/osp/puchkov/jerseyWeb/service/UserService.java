package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.service;

import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAO;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAONoDBImpl;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import javax.ws.rs.*;
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
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    public User getUsers(@PathParam("id") Integer id) {
        return userDAO.getUser(id);
    }

}
