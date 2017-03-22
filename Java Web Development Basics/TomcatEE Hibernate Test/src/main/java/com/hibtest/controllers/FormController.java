package com.hibtest.controllers;

import com.hibtest.entities.User;
import com.hibtest.repository.UserRepository;
import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Controller
@Stateless
public class FormController {

    @Inject
    private UserRepository userRepository;

    @GetMapping("/form")
    public String getFromPage(){
        return "form";
    }

    @PostMapping("/form")
    public String inputFormData(@RequestParam("username")String username,@RequestParam("password")String password){
        User user=new User(username,password);
        userRepository.create(user);
        return "form";
    }
}
