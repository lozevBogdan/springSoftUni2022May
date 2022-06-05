package bg.softUni.mobilele.web;

import bg.softUni.mobilele.model.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    @GetMapping("users/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("users/register")
    public String register(UserRegisterDto userRegisterDto){

        return "redirect:/";
    }
}
