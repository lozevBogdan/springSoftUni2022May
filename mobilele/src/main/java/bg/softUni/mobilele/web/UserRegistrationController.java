package bg.softUni.mobilele.web;

import bg.softUni.mobilele.model.dto.UserRegisterDto;
import bg.softUni.mobilele.service.UserService;
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
public class UserRegistrationController {


    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    // with @ModelAttribute method annotation we attach to Model UserRegisterDto,
    // which we can access in everywhere in templates

    @ModelAttribute("userModel")
    public void initUserModel(Model model){
        model.addAttribute("userModel",new UserRegisterDto());
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }


    // With @Valid we validate the data in field in userModel. BindingResults always should be become
    // ofter userModel and he catch the errors. With RedirectAttributes, we attach the userModel
    // bindingResult, they will be accessible in redirected page.
    // in this way we can redirect them to getmapping.
    //org.springframework.validation.BindingResult.userModel - is the name of Dto",
    // //bindingResult - the catch errors, they will catch by th:errorclass="is-invalid" in html,
    // and invalid-feedback class will be active and visible
    // with th:field in html we bind the field from entity with input form !

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel",userModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userModel",bindingResult);
            return "redirect:/users/register";
        }

        userService.registerAndLogin(userModel);
        return "redirect:/";
    }


}
