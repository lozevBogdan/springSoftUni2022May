package bg.softUni.demoSpringMVC.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String homePage(){
        System.out.println("hello");
        return "homepage";
    }

}
