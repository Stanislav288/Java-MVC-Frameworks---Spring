package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;

import javax.ejb.Stateless;

/**
 * Created by Galin on 3.3.2017 г..
 */
@Stateless
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(){
        return "/templates/home";
    }
}
