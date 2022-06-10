package com.softUni.cookieAndSession.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    private static final String LANG_SESSION_ATTRIBUTE = "lang";
    private static final String DEFAULT_LANG = "en";

// With HttpSession httpSession we can work with the userSessiion.
// Spring will create a new session,
// which session will be sended on the client in response headers,
// in cookie with name JSESSIONID
    @GetMapping("/session")
    public String session(HttpSession httpSession, Model model){

        var sessionLang = httpSession.getAttribute(LANG_SESSION_ATTRIBUTE);
        model.addAttribute("lang",
                sessionLang != null ? sessionLang : DEFAULT_LANG);

        return "session";
    }

    @PostMapping("/session")
    public String session(
            HttpSession httpSession,
            @RequestParam("language") String language
    ){

        httpSession.setAttribute("lang",language);

        return "redirect:/session";
    }

}
