package com.example.datalayer.service;

import com.example.datalayer.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class CustomerService {
    @PersistenceContext(unitName = "default")
    EntityManager entityManager;

    @Transactional
    public void customerInsert(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
    }

    @Transactional
    public List customerSelect(int page) {
        return entityManager.createNativeQuery("SELECT * FROM customers LIMIT " + page).getResultList();

    }

    @Transactional
    public Object customerSelectById(int id) {
        return entityManager.createNativeQuery("SELECT * FROM customers WHERE id = " + id).getSingleResult();
    }

    public void customerAlter(Customer customer) {
        String query = String.format("UPDATE customers SET cAddress = %s, cCountry = %s," +
                        " cEmailAddress = %s, " + "cFirstName = %s, cLastName = %s, cPhoneNumber = %s, cState = %s" +
                " WHERE id = %d" ,customer.getAddress(), customer.getCountry(), customer.getEmailAddress()
                , customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber()
                , customer.getState(), Math.toIntExact(customer.getId()));
        entityManager.createNativeQuery(query).executeUpdate();
    }
}
