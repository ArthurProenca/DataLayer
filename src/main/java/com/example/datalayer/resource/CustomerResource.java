package com.example.datalayer.resource;

import com.example.datalayer.entity.Customer;
import com.example.datalayer.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response handleCostumerRequest(Customer customer) {
        customerService.customerInsert(customer);
        return Response.ok().build();
    }
}