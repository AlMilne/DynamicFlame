package org.au.dynamicflame.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * NewsController.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 10/01/2014
 */
@Controller
public class NewsController {

    private static final Logger LOGGER = Logger.getLogger("NewsController");

    @Autowired
    private NewsService newsService;

    /**
     * handleRequest - TODO Alasdair COMMENT MISSING.
     * 
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadFormPage(Model m) {
        LOGGER.log(Level.INFO, "in loadFormPage");
        m.addAttribute("newsArticle", new NewsArticle());
        return "newsAdmin";
    }

    /**
     * processPerson - TODO Alasdair COMMENT MISSING.
     * 
     * @param newsArticle
     * @return
     */
    @RequestMapping(value = "/articleDetails", method = RequestMethod.POST)
    public String processNewsArticle(@ModelAttribute("newsArticle") @Valid NewsArticle newsArticle, BindingResult result, Model m) {

        if (result.hasErrors()) {
            return "newsAdmin";
        }

        LOGGER.log(Level.INFO, "in processNewsArticle");
        LOGGER.log(Level.INFO, "Title: {0} ", newsArticle.getTitle());

        newsArticle.setAuthor("admin");
        short imageid = 1;
        newsArticle.setImage_id(imageid);

        m.addAttribute("article", newsArticle);

        newsService.addNewsArticle(newsArticle);

        m.addAttribute("articleList", newsService.listNewsArticles());

        return "articleDetails";
    }

    @RequestMapping(value = "/delete/{story_id}")
    public String deleteContact(@PathVariable("story_id") final Integer story_id, Model m) {

        newsService.removeNewsArticles(story_id);
        
        m.addAttribute("articleList", newsService.listNewsArticles());

        return "articleDetails";
    }
}
