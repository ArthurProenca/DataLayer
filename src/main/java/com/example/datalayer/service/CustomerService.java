package com.example.datalayer.service;

import com.example.datalayer.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CustomerService {
    @PersistenceContext(unitName = "default")
    EntityManager entityManager;

    @Transactional
    public void customerInsert(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
    }
}
