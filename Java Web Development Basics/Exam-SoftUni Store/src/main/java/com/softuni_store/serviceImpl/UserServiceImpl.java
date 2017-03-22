package com.softuni_store.serviceImpl;

import com.softuni_store.entites.User;
import com.softuni_store.models.bindingModels.CreateUserModel;
import com.softuni_store.models.bindingModels.LoggedUserModel;
import com.softuni_store.repositories.UserRepository;
import com.softuni_store.service.UserService;
import com.softuni_store.utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void save(CreateUserModel createUserModel) {
        User user=this.modelParser.convert(createUserModel,User.class);
        this.userRepository.create(user);
    }

    @Override
    public CreateUserModel findByEmail(String email) {
        User user=this.userRepository.findByEmail(email);
        CreateUserModel foundUser=null;
        if(user!=null){
            foundUser=this.modelParser.convert(user,CreateUserModel.class);
        }

        return foundUser;
    }

    @Transactional
    @Override
    public LoggedUserModel findByEmailAndPassword(String email, String password) {
        User user=this.userRepository.findByEmailAndPassword(email, password);
        LoggedUserModel loggedUserModel=null;
        if(user!=null){
            loggedUserModel=this.modelParser.convert(user,LoggedUserModel.class);
        }

        return loggedUserModel;
    }


}
