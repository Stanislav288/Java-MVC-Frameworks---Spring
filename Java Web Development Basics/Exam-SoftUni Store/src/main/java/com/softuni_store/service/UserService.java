package com.softuni_store.service;


import com.softuni_store.entites.User;
import com.softuni_store.models.bindingModels.CreateUserModel;
import com.softuni_store.models.bindingModels.LoggedUserModel;

public interface UserService {
    void save(CreateUserModel createUserModel);

    CreateUserModel findByEmail(String email);

    LoggedUserModel findByEmailAndPassword(String email, String password);
}
