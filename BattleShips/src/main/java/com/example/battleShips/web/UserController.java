package com.example.battleShips.web;

import com.example.battleShips.dtos.UserLoginDto;
import com.example.battleShips.dtos.UserRegisterDto;
import com.example.battleShips.entity.UserEntity;
import com.example.battleShips.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @ModelAttribute
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @ModelAttribute
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto,BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        boolean freeUsernameAndEmail = this.
                userService.
                checkFreeUsernameAndEmail(userRegisterDto.getUsername(),userRegisterDto.getEmail());



//        boolean passIdentity = userRegisterDto.getPassword().
//                equals(userRegisterDto().getConfirmPass());

//        System.out.println(userRegisterDto);

        if (bindingResult.hasErrors() || !freeUsernameAndEmail ||
                !this.userService.checkPasswords(userRegisterDto.getPassword(),
                        userRegisterDto.getConfirmPass())) {

            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);

            return "redirect:/users/register";
        }



        this.userService.register(userRegisterDto);

        return "redirect:login";
    }


    @GetMapping("/login")
    public String loginPage(Model model){


        if(!model.containsAttribute("existingUser")){
            model.addAttribute("existingUser",true);

        }
        return "login";
    }


    @PostMapping("/login")
    public String register(@Valid UserLoginDto userLoginDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        Optional<UserEntity> existingUser =
                this.userService.checkForExistingUsernameWithPassword(userLoginDto().getUsername(),
                userLoginDto.getPassword());

        System.out.println();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDto", bindingResult);
            redirectAttributes.addFlashAttribute("existingUser", existingUser);
            return "redirect:/users/login";
        }

        this.userService.loginUser(userLoginDto);
        return "redirect:/";
    }




}
