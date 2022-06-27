package com.softUni.cookieAndSession.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
                          ) String lang) {

        model.addAttribute(LANG_COOKIE_NAME, lang);

        return "cookies";
    }


    // The value of " @RequestParam("language") String language"  will comes
    // from cookies.html form by selected option

    // HttpServletResponse httpServletResponse = is a object representation of the
    // responce which we return to the client, here we add the cookie
    @PostMapping("/cookies")
    public String cookies(
            HttpServletResponse httpServletResponse,
            @RequestParam("language") String language
    ) {

        Cookie cookie = new Cookie(LANG_COOKIE_NAME, language);
        httpServletResponse.addCookie(cookie);

        return "redirect:/cookies";
    }

}
