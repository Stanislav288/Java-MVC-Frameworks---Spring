package com.softuni_store.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import com.softuni_store.models.bindingModels.CreateUserModel;
import com.softuni_store.models.bindingModels.LoggedUserModel;
import com.softuni_store.models.bindingModels.LoginUserModel;
import com.softuni_store.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Stateless
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "/templates/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute CreateUserModel createUserModel, Model model) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<CreateUserModel>> constraintViolations = validator.validate(createUserModel);
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<CreateUserModel> constraint : constraintViolations) {
            errors.add(constraint.getMessage());
        }

        if (!createUserModel.getPassword().equals(createUserModel.getConfirmPassword())) {
            errors.add("Password Mismatch");
        }

        CreateUserModel foundUser = this.userService.findByEmail(createUserModel.getEmail());
        if (foundUser != null) {
            errors.add("The user already exists");
        }

        if (errors.size() != 0) {
            model.addAttribute("errors", errors);
            return "/templates/register";
        }

        this.userService.save(createUserModel);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/templates/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginUserModel loginUserModel, HttpSession session,Model model) {
        LoggedUserModel foundUser = this.userService.findByEmailAndPassword(loginUserModel.getEmail(), loginUserModel.getPassword());
        if(foundUser==null){
            List<String> errors = new ArrayList<>();
            errors.add("Invalid Login Details");
            model.addAttribute("errors", errors);
            return "/templates/login";
        }

        session.setAttribute("user", foundUser);

        return "redirect:/register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
/*
    @GetMapping("/user/profile")
    public String getUserProfile(@RequestParam("profileId") long profileId, Model model) {
        UserTopicsViewModel userTopicsViewModel = this.userService.findById(profileId);
        model.addAttribute("userTopicsViewModel",userTopicsViewModel);
        model.addAttribute("profileId", profileId);

        return "/templates/profile";
    }
*/
}
