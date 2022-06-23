package com.example.battleShips.web;

import com.example.battleShips.currUser.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public String indexPage(){

        if (!currentUser.isLogged()){
            return "index";
        }

        return "redirect:home";

    }

    @GetMapping("/home")
    public String homePage(){

        if (!currentUser.isLogged()){
            return "redirect:/";
        }

        return "home";

    }

}
