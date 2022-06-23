package com.example.battleShips.web;


import com.example.battleShips.currUser.CurrentUser;
import com.example.battleShips.dtos.ShipsViewDto;
import com.example.battleShips.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public HomeController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    public String indexPage(){

        if (!currentUser.isLogged()){
            return "index";
        }

        return "redirect:home";

    }

    @GetMapping("/home")
    public String homePage(Model model){

        if (!currentUser.isLogged()){
            return "redirect:/";
        }

        List<ShipsViewDto> allShipsViewDto =
                this.shipService.getAllShips();

        model.addAttribute("allShips",allShipsViewDto);


        List<ShipsViewDto> otherShips =
                this.shipService.getAllShipsOfOtherUsers();

        model.addAttribute("otherShips",otherShips);


        List<ShipsViewDto> currentUserShips =
                this.shipService.getAllShipsOfCurrentUser();

        model.addAttribute("currentUserShips",currentUserShips);

        return "home";

    }

}
