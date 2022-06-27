package com.example.examspringfundskeleton.web;

import com.example.examspringfundskeleton.currUser.CurrentUser;
import com.example.examspringfundskeleton.dtos.UserLoginDto;
import com.example.examspringfundskeleton.dtos.UserRegisterDto;
import com.example.examspringfundskeleton.service.UserService;
import org.springframework.stereotype.Controller;
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
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }

    @ModelAttribute
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @GetMapping("/login")
    public String login(){

        if(this.userService.isUserLoggedIn()){
            return "redirect:/home";
        }


        return "login";
    }

    @GetMapping("/delete/all")
    public String deleteAll(){

        if(!this.userService.isUserLoggedIn()){
            return "redirect:/";
        }

        this.userService.deleteAllSongsFromPLayList();
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(){

        if(this.userService.isUserLoggedIn()){
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDto userLoginDto, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(this.userService.isUserLoggedIn()){
            return "redirect:home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDto", bindingResult);

            return "redirect:/users/login";
        }

        boolean existCredentials = this.userService.existingCredentialsInDb(userLoginDto.getUsername(),
                userLoginDto.getPassword());

        if(!existCredentials){
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute(
                    "isNotExistUser", true);

            return "redirect:/users/login";

        }

        this.userService.loginUser(userLoginDto);

        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(this.userService.isUserLoggedIn()){
            return "redirect:home";
        }

        boolean userNameIsNotFree = this.userService.existingUsername(userRegisterDto.getUsername());

        boolean passwordsAreEquals = this.userService.checkPasswordsEquals(userRegisterDto.getPassword(),
                userRegisterDto.getConfirmPassword());

        boolean emailIsNotFree = this.userService.existingEmail(userRegisterDto.getEmail());


        if (bindingResult.hasErrors() || userNameIsNotFree || !passwordsAreEquals || emailIsNotFree) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("userNameIsNotFree", userNameIsNotFree);
            redirectAttributes.addFlashAttribute("emailIsNotFree", emailIsNotFree);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            redirectAttributes.addFlashAttribute(
                    "passwordsNotMach",!passwordsAreEquals);
            return "redirect:/users/register";
        }


        userService.registerUser(userRegisterDto);

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(){

        if(!this.userService.isUserLoggedIn()){
            return "redirect:/";
        }

        this.userService.logoutUser();
        return "redirect:/";
    }

}
