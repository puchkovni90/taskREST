package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.service;

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
    private UserDAO userDAO;
    public UserService() {
        //TODO: change to DB DAO if added
        userDAO = new UserDAONoDBImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> users = userDAO.getUsers();
        if (users == null || users.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        GenericEntity<List<User>> result = new GenericEntity<List<User>>(users){};

        return Response.ok(result).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Integer id) {
        User result = userDAO.getUser(id);
        if (result == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(userDAO.getUser(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        if (!userDAO.addUser(user))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        return Response.ok(user).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        if (!userDAO.updateUser(user))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}") //according to {@link https://habr.com/post/38730/}
    public Response deleteUser(@PathParam("id") Integer id) {
        if (!userDAO.deleteUser(id))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        return Response.ok().build();
    }
}
