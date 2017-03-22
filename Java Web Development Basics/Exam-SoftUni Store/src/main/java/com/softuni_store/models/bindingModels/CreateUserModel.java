package com.softuni_store.models.bindingModels;

import com.mvcFramework.annotations.parameters.PathVariable;

import javax.validation.constraints.Pattern;

public class CreateUserModel {

    @Pattern(regexp = "^[a-zA-Z -.]+$", message = "Incorrect Full Name!")
    private String fullName;

    @Pattern(regexp = "^(?=.*[@]).{2,}$", message = "Incorrect Email!")
    private String email;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message = "Incorrect Password!")
    private String password;

    private String confirmPassword;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
