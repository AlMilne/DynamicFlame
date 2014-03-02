package org.au.dynamicflame.controllers;

import org.au.dynamicflame.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DefaultController.java - Default controller to handle app start up and page load.
 *
 * @author Alasdair
 * @since 02/02/2014
 */
@Controller
public class DefaultController {

    private static final String INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return INDEX;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage() {
        return INDEX;
    }

    @RequestMapping(value = "/melville.html", method = RequestMethod.GET)
    public String melville() {
        return "melville";
    }

    @RequestMapping(value = "/cannington.html", method = RequestMethod.GET)
    public String cannington() {
        return "cannington";
    }

    @RequestMapping(value = "/hainsworth.html", method = RequestMethod.GET)
    public String hainsworth() {
        return "hainsworth";
    }

    @RequestMapping(value = "/curtin.html", method = RequestMethod.GET)
    public String curtin() {
        return "curtin";
    }

    @RequestMapping(value = "/vicpark.html", method = RequestMethod.GET)
    public String vicpark() {
        return "vicpark";
    }

    @RequestMapping(value = "/langford.html", method = RequestMethod.GET)
    public String langford() {
        return "langford";
    }

    @RequestMapping(value = "/heathridge.html", method = RequestMethod.GET)
    public String heathridge() {
        return "heathridge";
    }

    @RequestMapping(value = "/kingsway.html", method = RequestMethod.GET)
    public String kingsway() {
        return "kingsway";
    }

    @RequestMapping(value = "/photos.html", method = RequestMethod.GET)
    public String photos() {
        return "photos";
    }

    @RequestMapping(value = "/about.html", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public String contact(final Model model) {
        model.addAttribute("email", new Email());
        return "contact";
    }

    @RequestMapping(value = "/emailThanks.html", method = RequestMethod.GET)
    public String emailThanks() {
        return "emailThanks";
    }
}
