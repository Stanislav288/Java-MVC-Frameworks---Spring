package mvcFramework.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.request.GetMapping;

/**
 * Created by Galin on 22.2.2017 г..
 */

@Controller
public class TestController {

    @GetMapping("/test")
    public String getTestPage(){
        return null;
    }
}
