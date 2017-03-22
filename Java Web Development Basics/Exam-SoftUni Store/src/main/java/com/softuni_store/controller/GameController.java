package com.softuni_store.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import com.softuni_store.entites.Game;
import com.softuni_store.models.bindingModels.GameBindingModel;
import com.softuni_store.models.bindingModels.GameEditBindingModel;
import com.softuni_store.models.bindingModels.LoggedUserModel;
import com.softuni_store.models.viewModels.GameDetailsViewModel;
import com.softuni_store.models.viewModels.GameEditViewModel;
import com.softuni_store.models.viewModels.GameHomeViewModel;
import com.softuni_store.models.viewModels.GameViewModel;
import com.softuni_store.service.GameService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Galin on 5.3.2017 г..
 */
@Stateless
@Controller
public class GameController {

    @Inject
    private GameService gameService;

    @GetMapping("/game/add")
    public String getAddGamePage(){
        return "/templates/add-game";
    }

    @PostMapping("/game/add")
    public String addGame(@ModelAttribute GameBindingModel gameBindingModel, HttpSession session){
        LoggedUserModel loggedUserModel= (LoggedUserModel) session.getAttribute("user");
        String email=loggedUserModel.getEmail();
        this.gameService.save(gameBindingModel,email);

        return "redirect:/game/all";
    }

    @GetMapping("/game/all")
    public String getAdminGamesPage(Model model){
        List<GameViewModel> gameViewModels=this.gameService.findAll();
        model.addAttribute("games",gameViewModels);

        return "/templates/games";
    }

    @GetMapping("/game/edit/{id}")
    public String getEditGamePage(@PathVariable("id") long id, Model model){
        GameEditViewModel gameEditViewModel=this.gameService.findById(id);
        model.addAttribute("game",gameEditViewModel);
        return "/templates/edit-game";
    }

    @PostMapping("/game/edit/{id}")
    public String editGame(@PathVariable("id") long id, @ModelAttribute GameEditBindingModel gameEditBindingModel){
        gameEditBindingModel.setId(id);
        this.gameService.update(gameEditBindingModel);
        return "redirect:/game/all";
    }

    @GetMapping("/game/delete/{id}")
    public String getDeleteGamePage(@PathVariable("id") long id, Model model){
        GameEditViewModel gameEditViewModel=this.gameService.findById(id);
        model.addAttribute("game",gameEditViewModel);
        return "/templates/delete-game";
    }

    @PostMapping("/game/delete/{id}")
    public String deleteGame(@PathVariable("id") long id){
        this.gameService.deleteById(id);
        return "redirect:/game/all";
    }

    @GetMapping("/game/details/{id}")
    public String getGameDetailsPage(@PathVariable("id") long id, Model model){
        GameDetailsViewModel gameDetailsViewModel=this.gameService.findGameDetails(id);
        model.addAttribute("game",gameDetailsViewModel);
        return "/templates/game-details";
    }

}
