package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.dto.UserRegistrationDto;
import bg.softuni.pathfinder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // with @ModelAttribute method annotation we attach to Model UserRegisterDto,
    // which we can access in everywhere in templates.
    // Its important to put the NAME OF ATTRIBUTE, AFTER ANNOTATION If the method is void !!!!!!!!!!!!!
    //@ModelAttribute("NAMEOFTTRIBUTE") in other way,
    // the nameof ModelAttribute will become the name of returned class!!!!!!!

    @ModelAttribute("userRegistrationDto")
    public void initForm(Model model) {
        model.addAttribute("userRegistrationDto", new UserRegistrationDto());
    }


    @GetMapping("/register")

    public String register() {

        return "register";
    }

    //  redirectAttributes.addFlashAttribute attach attribute to Model !!!!!
    @PostMapping("/register")
    public String register(@Valid UserRegistrationDto userRegistrationDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.
                    addFlashAttribute(
                            "org.springframework.validation.BindingResult.userRegistrationDto",
                            bindingResult);
            redirectAttributes.
                    addFlashAttribute("userRegistrationDto", userRegistrationDto);

            return "redirect:/register";
        }

        // check if passwords match
        //check if username/email is used


        // insert in DB

        this.authService.register(userRegistrationDto);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
