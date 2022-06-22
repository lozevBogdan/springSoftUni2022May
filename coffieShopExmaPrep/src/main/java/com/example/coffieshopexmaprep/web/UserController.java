package com.example.coffieshopexmaprep.web;

import com.example.coffieshopexmaprep.currentUser.CurrentUser;
import com.example.coffieshopexmaprep.dto.UserLoginDto;
import com.example.coffieshopexmaprep.dto.UserRegistrationDto;
import com.example.coffieshopexmaprep.service.UserService;
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
    public UserRegistrationDto userRegistrationDto(){

        return new UserRegistrationDto();
    }

    @ModelAttribute
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String login(Model model){

        if(!model.containsAttribute("isNotExistUser")){
            model.addAttribute("isNotExistUser",false);
        }

        return "login";
    }


    @PostMapping("/login")
    public String login(@Valid UserLoginDto userLoginDto,BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDto", bindingResult);

            return "redirect:/users/login";
        }

        boolean isNotExistUser =
               this.userService.loginUser(userLoginDto);

        if(!isNotExistUser){
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute(
                    "isNotExistUser", true);

            return "redirect:/users/login";

        }

        System.out.println(this.currentUser);

        return "redirect:/";
    }


    @GetMapping("/register")
    public String register(Model model){

        if(!model.containsAttribute("notMachPass")){
            model.addAttribute("notMachPass",false);
        }
        if(!model.containsAttribute("userNameIsFree")){
            model.addAttribute("userNameIsFree",true);
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDto userRegistrationDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        boolean userNameIsFree =
                this.userService.checkUsernameIsFree(userRegistrationDto.getUsername());

        if (bindingResult.hasErrors() || !userNameIsFree) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            redirectAttributes.addFlashAttribute("userNameIsFree", userNameIsFree);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);

            return "redirect:/users/register";
        }

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword()) ) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            redirectAttributes.addFlashAttribute(
                    "notMachPass",true);

            return "redirect:/users/register";
        }

        userService.registerUser(userRegistrationDto);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logout();
        return "home";
    }




}
