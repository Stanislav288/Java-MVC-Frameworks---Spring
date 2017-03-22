package com.softuni_store.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;
import com.softuni_store.models.viewModels.GameHomeViewModel;
import com.softuni_store.models.viewModels.GameViewModel;
import com.softuni_store.service.GameService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@Controller
public class HomeController {

    @Inject
    private GameService gameService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<GameHomeViewModel> gameHomeViewModels=this.gameService.findAllWithExtraInfo();
        model.addAttribute("games",gameHomeViewModels);
        return "/templates/home";
    }
}
