package com.example.datalayer.resource;

import com.example.datalayer.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerResource {
    @PersistenceContext(unitName = "default")
    EntityManager entityManager;

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String handleCostumerRequest(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
        return customer.toString();
    }
}