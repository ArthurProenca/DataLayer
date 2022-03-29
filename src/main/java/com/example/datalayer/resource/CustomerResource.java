package com.example.datalayer.resource;

import com.example.datalayer.entity.Customer;
import com.example.datalayer.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.List;

@Path("/customer")
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response handleCustomerRequest(Customer customer) {
        customerService.customerInsert(customer);
        return Response.ok().build();
    }

    @Path("/select/paginated/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Customer> handleCustomerResponse(@PathParam("id") String id){
        return customerService.customerSelect(Integer.parseInt(id));
    }

    @Path("/select/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Object handleSingleCustomerResponse(@PathParam("id") int id){
        return customerService.customerSelectById(id);
    }

    @Path("/update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response handleCustomerAlter(Customer customer){
        customerService.customerAlter(customer);
        return Response.ok().build();
    }
}