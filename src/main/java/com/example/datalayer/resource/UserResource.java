package com.example.datalayer.resource;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserResource {


    @Path("/login")
    @GET
    //@Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response handleCostumerRequest() {
        return Response.ok().build();
    }
}
