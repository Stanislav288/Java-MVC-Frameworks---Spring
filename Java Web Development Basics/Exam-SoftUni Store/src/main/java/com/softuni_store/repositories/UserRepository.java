package com.softuni_store.repositories;


import com.softuni_store.entites.User;

public interface UserRepository {

    void create(User user);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findById(long id);
}
