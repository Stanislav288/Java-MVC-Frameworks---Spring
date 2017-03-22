package mvcFramework.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.RequestParam;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;

/**
 * Created by Galin on 22.2.2017 г..
 */
@Controller
public class BeerController {

    @GetMapping("/beer")
    public String getBeer() {
        return "beer";
    }

    @PostMapping("/beer")
    public String submitBeer(@RequestParam("beerBrand") String beerBrand,@RequestParam("price")String price){
        return "beer";
    }

    @PostMapping("/beer")
    public String postBeerBrand(@RequestParam("beerBrand") String brand) {
        System.out.println(brand);
        return "redirect:/beer";
    }
}
