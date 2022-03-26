package com.example.datalayer.resource;

import com.example.datalayer.entity.Customer;
import com.example.datalayer.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void handleCostumerRequest(Customer customer) {
//        entityManager.persist(customer);
//        entityManager.flush();
        customerService.customerInsert(customer);
    }
}