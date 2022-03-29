package com.example.datalayer.resource;


import com.example.datalayer.entity.Customer;
import com.example.datalayer.entity.User;
import com.example.datalayer.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserResource {
    @Inject
    UserService userService;

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response handleUserInsertion(User user) {
        userService.userInsert(user);
        return Response.ok().build();
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response handleUserLogin(User user) {
        if (userService.userLogin(user) != null) {
            return Response.ok().build();
        } else {
            return Response.status(401).build();
        }
    }

}
