package bg.softUni.mobilele.web;

import bg.softUni.mobilele.model.dto.UserLoginDto;
import bg.softUni.mobilele.model.dto.UserRegisterDto;
import bg.softUni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto){
      userService.login(userLoginDto);
        return "redirect:/";
    }



}
