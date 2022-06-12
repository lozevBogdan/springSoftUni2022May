package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDto userRegistrationDto){
        System.out.println(userRegistrationDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



}
