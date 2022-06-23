package com.example.battleShips.web;

import com.example.battleShips.currUser.CurrentUser;
import com.example.battleShips.dtos.ShipAddDto;
import com.example.battleShips.dtos.UserLoginDto;
import com.example.battleShips.entity.UserEntity;
import com.example.battleShips.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/ships")
public class ShipsController {

    private final ShipService shipService;
    private final CurrentUser currentUser;

    public ShipsController(ShipService shipService, CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public ShipAddDto shipAddDto(){
        return new ShipAddDto();
    }

    @GetMapping("/add")
    public String add(Model model){

        if (!currentUser.isLogged()){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("existSameName" )){
            model.addAttribute("existSameName",false);
        }

        return "ship-add";
    }


    @PostMapping("/add")
    public String register(@Valid ShipAddDto shipAddDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){


       boolean existSameName =  this.shipService.checkForExistingName(shipAddDto.getName());

        if (bindingResult.hasErrors() || existSameName) {
            redirectAttributes.addFlashAttribute("shipAddDto", shipAddDto);
            redirectAttributes.addFlashAttribute("existSameName", existSameName);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.shipAddDto", bindingResult);

            return "redirect:add";
        }

        this.shipService.addToDb(shipAddDto);


        return "redirect:/";
    }

}
