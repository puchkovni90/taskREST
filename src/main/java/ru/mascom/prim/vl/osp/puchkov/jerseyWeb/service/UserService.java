package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.service;

import org.apache.log4j.Logger;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAO;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.DAO.UserDAONoDBImpl;
import ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    private UserDAO userDAO;
    public UserService() {
        //TODO: change to DB DAO if added
        userDAO = new UserDAONoDBImpl();
        LOGGER.warn("Connecting service to no-database dummy.");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> users = userDAO.getUsers();
        if (users == null || users.isEmpty()) {
            LOGGER.info("Got empty or null list of users");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        LOGGER.debug("Got list of users, count of elements: " + users.size());

        GenericEntity<List<User>> result = new GenericEntity<List<User>>(users){};

        return Response.ok(result).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Integer id) {
        User result = userDAO.getUser(id);
        if (result == null) {
            LOGGER.info("user by id not found. id: " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        LOGGER.debug("got user by id: " + id);
        return Response.ok(userDAO.getUser(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        if (!userDAO.addUser(user)) {
            LOGGER.warn("can't add a user: " + user.toString());
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }

        LOGGER.debug("added new user: " + user.toString());
        return Response.ok(user).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        if (!userDAO.updateUser(user)) {
            LOGGER.warn("can't update a user: " + user);
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        LOGGER.debug("updated a user: " + user.toString());
        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}") //according to {@link https://habr.com/post/38730/}
    public Response deleteUser(@PathParam("id") Integer id) {
        if (!userDAO.deleteUser(id)) {
            LOGGER.warn("can't delete a user by id: " + id);
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        LOGGER.debug("user deleted by id: " + id);
        return Response.ok().build();
    }
}
