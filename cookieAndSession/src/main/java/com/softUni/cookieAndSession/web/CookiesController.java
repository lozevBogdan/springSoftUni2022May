package com.softUni.cookieAndSession.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookiesController {

private static final String LANG_COOKIE_NAME = "lang";


// with @CookieValue we try to read cookie from HTTP,
// with name "LANG_COOKIE_NAME = "lang"",
// the value of cookie with this name will be returned

    @GetMapping("/cookies")
    public String cookies(Model model,
                          @CookieValue(
                                  name = LANG_COOKIE_NAME,
                                  defaultValue = "en"
                          )String lang){

        model.addAttribute(LANG_COOKIE_NAME,lang);

        return "cookies";
    }

//    @PostMapping("/cookies")
//    public String cookies(){
//
//        return "redirect:/cookies";
//    }

}
