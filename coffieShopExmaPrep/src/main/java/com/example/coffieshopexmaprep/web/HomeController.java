package com.example.coffieshopexmaprep.web;

import com.example.coffieshopexmaprep.currentUser.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String homePage(){

        if (currentUser.getId() == null){
            return "index";
        }
        //todo logic for loged in user
        return "home";
    }


}
