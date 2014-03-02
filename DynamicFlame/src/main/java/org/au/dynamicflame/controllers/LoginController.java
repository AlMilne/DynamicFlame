package org.au.dynamicflame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LoginController.java - handles the security login process to navigate to the login.jsp page on request and return to
 * the news.jsp page by default after successful losgin.
 * 
 * @author Alasdair
 * @since 16/02/2014
 */
@Controller
public class LoginController {

    /** LOGIN */
    private static final String LOGIN = "login";

    /**
     * login - request mapping method to navigate login form page
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return LOGIN;
    }

    /**
     * login - request mapping method to reload login form page on login failure
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return LOGIN;
    }

    /**
     * login - request mapping method to redirect back to news page after logout
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "redirect:/news";
    }

}
