package com.example.examspringfundskeleton.web;

import com.example.examspringfundskeleton.currUser.CurrentUser;
import com.example.examspringfundskeleton.dtos.UserLoginDto;
import com.example.examspringfundskeleton.dtos.UserRegisterDto;
import com.example.examspringfundskeleton.entity.UserEntity;
import com.example.examspringfundskeleton.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CurrentUser currentUser;


    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @ModelAttribute
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }


    @GetMapping("/login")
    public String login(){

        if(currentUser.isLogged()){
            return "redirect:/home";
        }

        return "login";
    }


    @GetMapping("/register")
    public String register(Model model){

        if(currentUser.isLogged()){
            return "redirect:/home";
        }

        if (!model.containsAttribute("usernameIsNotFree")){
            model.addAttribute("usernameIsNotFree",false);
        }

        if (!model.containsAttribute("passwordsNotEquals")){
            model.addAttribute("passwordsNotEquals",false);
        }

        if (!model.containsAttribute("badCredentials")){
            model.addAttribute("badCredentials",false);
        }


        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(currentUser.isLogged()){
            return "redirect:/home";
        }

        boolean checkForExistingUsername=
                this.userService.checkForExistingUsername(userRegisterDto.getUsername());

        boolean checkPasswords = userRegisterDto.getPassword()
                .equals(userRegisterDto.getConfirmPassword());

        System.out.println(userRegisterDto);

        if (bindingResult.hasErrors() || checkForExistingUsername || !checkPasswords) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto",
                    bindingResult);

            System.out.println();

            if (checkForExistingUsername){
                redirectAttributes.addFlashAttribute
                        ("usernameIsNotFree", checkForExistingUsername);
            }
            if (!checkPasswords){
                redirectAttributes.addFlashAttribute
                        ("passwordsNotEquals", !checkPasswords);
            }



            return "redirect:/users/register";
        }

        UserEntity newUser =  this.userService.register(userRegisterDto);

        return "redirect:login";
    }


    @PostMapping("/login")
    public String login(@Valid UserLoginDto userLoginDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(currentUser.isLogged()){
            return "redirect:/home";
        }

        boolean checkForExistingUser=
                this.userService.checkForExistingUserByUsenameAndPassword
                        (userLoginDto.getUsername(),userLoginDto.getPassword());



        if (bindingResult.hasErrors() || !checkForExistingUser) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDto",
                    bindingResult);

            if (!checkForExistingUser){
                redirectAttributes.addFlashAttribute
                        ("badCredentials", true);
            }


            return "redirect:/users/login";
        }

        this.userService.login(userLoginDto);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){

        if(!currentUser.isLogged()){
            return "redirect:/login";
        }
                this.userService.logout();

       return  "redirect:/";
    }

}
