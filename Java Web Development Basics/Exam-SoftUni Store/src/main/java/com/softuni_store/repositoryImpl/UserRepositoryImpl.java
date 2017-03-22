package com.softuni_store.repositoryImpl;


import com.softuni_store.entites.User;
import com.softuni_store.repositories.UserRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query query = this.entityManager.createQuery("SELECT u FROM User AS u " +
                "WHERE u.email = :email " +
                "AND u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        return users.stream().findFirst().orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        Query query = this.entityManager.createQuery("SELECT u FROM User AS u " +
                "WHERE u.email = :email");
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        return users.stream().findFirst().orElse(null);
    }

    @Override
    public User findById(long id) {
        return this.entityManager.find(User.class, id);
    }
}
