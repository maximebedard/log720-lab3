package ca.etsmtl.log720.lab3.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/auth")
public class AuthenticationsController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String login(){
        return "auth/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/auth/login?logout";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    private String denied() { return "auth/denied"; }
}
