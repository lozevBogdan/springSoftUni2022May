package bg.softUni.mobilele.web;

import bg.softUni.mobilele.model.dto.UserLoginDto;
import bg.softUni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @GetMapping("/users/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }



    @PostMapping("/users/login")
    public String login(UserLoginDto userLoginDto){
      userService.login(userLoginDto);
        return "redirect:/";
    }

}
