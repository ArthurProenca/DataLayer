package com.example.datalayer.service;

import com.example.datalayer.entity.User;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

public class UserService {
    @PersistenceContext(unitName = "default")
    EntityManager entityManager;

    @Inject
    Pbkdf2PasswordHash passwordHash;

    @Transactional
    public void userInsert(User user) {
        User aux = new User();
        aux.setUsername(user.getUsername());
        aux.setPassword(passwordHash.generate(user.getPassword().toCharArray()));
        aux.setGroup(user.getGroup());
        entityManager.persist(user);
        entityManager.flush();
    }

    @Transactional
    public Object userLogin(User user) {
        try{
            return entityManager.createNativeQuery(String.format("SELECT * FROM user WHERE username = '%s'" +
                    " AND user_password = '%s'", user.getUsername(), user.getPassword())).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
