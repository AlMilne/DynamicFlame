package org.au.dynamicflame.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * NewsController.java - Controller for the news page. Handles the mapping for creating new news stories as well as the
 * displaying and deleting of stories. PageListHolder used to handle pagination of results on the screen.
 * 
 * @author Alasdair
 * @since 10/01/2014
 */
@Controller
@SessionAttributes("newsArticle")
public class NewsController {

    /** ARTICLE_LIST_VIEW */
    private static final String ARTICLE_LIST = "articleList";

    private static final Logger LOGGER = Logger.getLogger("NewsController");

    @Autowired
    private NewsService newsService;
    
    /**
     * loadFormPage - initial page load mapping to add newsArticle to the model and return the newsAdmin.jsp view.
     * 
     * @param model
     * @return String - view to display
     */
    @RequestMapping(value = "/newsAdmin", method = RequestMethod.GET)
    public String loadFormPage(Model model) {
        LOGGER.log(Level.INFO, "in loadFormPage");
        model.addAttribute("newsArticle", new NewsArticle());
        return "newsAdmin";
    }

    /**
     * processNewsArticle - adds a new newsArticle into the db using the details entered on the newsAdmin.jsp form. Uses
     * JSR 303 validation for the newsArticle and re-displays the newsAdmin page if not valid..
     * 
     * @param request
     * @param response
     * @param newsArticle
     * @param result
     * @param model
     * @return String - view to display
     */
    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public String processNewsArticle(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("newsArticle") @Valid NewsArticle newsArticle, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "newsAdmin";
        }

        LOGGER.log(Level.INFO, "in processNewsArticle");

        // Add some default values to required model fields not yet captured
        newsArticle.setAuthor("admin");
        short imageid = 1;
        newsArticle.setImageId(imageid);

        newsService.addNewsArticle(newsArticle);

        request.getSession().setAttribute(ARTICLE_LIST, null);
        // Populate PagedListHolder with news articles
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);

        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        return "news";
    }

    /**
     * viewNewsArticles - handles the redisplaying of the articles page so that the PagedListHolder gets re-populated
     * with the articles.
     * 
     * @param request
     * @param response
     * @param model
     * @return String - view to display
     */
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String viewNewsArticles(HttpServletRequest request, HttpServletResponse response, Model model) {
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);

        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        return "news";
    }

    /**
     * deleteNewsArticle - removes the selected news story from the db.
     * 
     * @param story_id
     * @param model
     * @return String - view to display
     */
    @RequestMapping(value = "/delete/{story_id:\\d+}", method = RequestMethod.GET)
    public String deleteNewsArticle(HttpServletRequest request, @PathVariable("story_id") final Integer story_id, Model model) {
        LOGGER.log(Level.INFO, "in deleteContact {0}", story_id);
        newsService.removeNewsArticles(story_id);

        // Set the articleList attribute to null to force refresh of the PagedLstHolder
        request.getSession().setAttribute(ARTICLE_LIST, null);
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);
        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        // Redirect so page reloads
        return "redirect:/news";
    }

    /**
     * editArticle - locates the news article that was selected for editing from the id path variable that matches the
     * story_id of the article. Adds the article to be updated into the model and then returns the editNews view to load
     * the page with the article details pre-populated.
     * 
     * TODO current finding of news story inefficient, should just return single article from db not have to return all
     * and search
     * 
     * @param id story_id of the news article to edit
     * @param model object to store the article in
     * @return editNews.jsp view
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable Integer id, Model model) {
        List<NewsArticle> articles = newsService.listNewsArticles();
        
        LOGGER.log(Level.INFO, "editArticle {0}", articles.size());

        for (Iterator<NewsArticle> iterator = articles.iterator(); iterator.hasNext();) {
            NewsArticle article = (NewsArticle) iterator.next();
            if (article.getStoryId() == id) {
                LOGGER.log(Level.INFO, "article {0}", article.getStoryId());
                model.addAttribute("newsArticle", article);
            }
        }

        return "editNews";
    }

    /**
     * updateArticle - updates the news article whose story_id matches that of the newsArticle passed in.
     * 
     * @param newsArticle object that contains the updated values
     * @param model object to store the pageListholder in for pagination
     * @return articleDetails.jsp view
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateArticle(@ModelAttribute NewsArticle newsArticle, Model model, HttpServletRequest request) {
        newsService.editNewsArticle(newsArticle);
        request.getSession().setAttribute(ARTICLE_LIST, null);
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);

        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        return "news";
    }

    /**
     * populatePagedListHolder - populates the Spring PagedListHolder class with the list of news stories in order to
     * handle the news story pagination. Retrieves the request object 'page' to determine which direction the navigation
     * of the pages should be processed.
     * 
     * @param request
     * @return
     */
    private PagedListHolder<NewsArticle> populatePagedListHolder(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        PagedListHolder<NewsArticle> pagedListHolder =
                (PagedListHolder<NewsArticle>) request.getSession().getAttribute(ARTICLE_LIST);

        // If first time on page populate the pagedListHolder with the news articles
        if (pagedListHolder == null) {
            List<NewsArticle> articleList = newsService.listNewsArticles();
            LOGGER.log(Level.INFO, "articleList - articleList.size(): {0}", articleList.size());
            pagedListHolder = new PagedListHolder<NewsArticle>(articleList);
        } else {
            String page = (String) request.getParameter("page");
            if ("next".equals(page)) {
                pagedListHolder.nextPage();
            } else if ("previous".equals(page)) {
                pagedListHolder.previousPage();
            }
        }

        return pagedListHolder;
    }
}
