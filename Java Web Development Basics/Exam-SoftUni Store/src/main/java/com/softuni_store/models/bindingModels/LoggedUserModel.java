package com.softuni_store.models.bindingModels;

import com.softuni_store.models.viewModels.GameEditViewModel;


import java.util.Set;

/**
 * Created by Galin on 5.3.2017 г..
 */
public class LoggedUserModel {
    private String fullName;

    private String email;

    private boolean isAdmin;

    private Set<GameEditViewModel> games;

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

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Set<GameEditViewModel> getGames() {
        return games;
    }

    public void setGames(Set<GameEditViewModel> games) {
        this.games = games;
    }
}
