package com.au.dynamicflame.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.au.dynamicflame.domain.NewsArticle;

/**
 * NewsController.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 10/01/2014
 */
@Controller
public class NewsController {

    private static final Logger LOGGER = Logger.getLogger("NewsController");

    /**
     * handleRequest - TODO Alasdair COMMENT MISSING.
     * 
     * @return
     */
    @RequestMapping("/newsAdmin")
    public ModelAndView handleRequest() {
        LOGGER.log(Level.INFO, "in news controller ");

        return new ModelAndView("newsAdmin", "news-article", new NewsArticle());
    }

    /**
     * processPerson - TODO Alasdair COMMENT MISSING.
     * 
     * @param newsArticle
     * @return
     */
    @RequestMapping(value = "/articleDetails", method = RequestMethod.POST)
    public ModelAndView processNewsArticle(@ModelAttribute NewsArticle newsArticle) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("articleDetails");
        LOGGER.log(Level.INFO, "in processNewsArticle");
        LOGGER.log(Level.INFO, "Title: {0} ", newsArticle.getTitle());

        modelAndView.addObject("article", newsArticle);

        return modelAndView;
    }
}
