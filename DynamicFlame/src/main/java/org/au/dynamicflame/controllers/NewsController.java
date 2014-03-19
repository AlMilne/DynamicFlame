package org.au.dynamicflame.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.service.NewsService;
import org.hibernate.ObjectNotFoundException;
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

    private static final String NEWS_ADMIN_PAGE = "newsAdmin";

    private static final String NEWS_PAGE = "news";

    private static final String NEWS_ARTICLE = "newsArticle";

    private static final String REDIRECT_NEWS = "redirect:/news";

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
    public String loadFormPage(final Model model) {
        LOGGER.log(Level.INFO, "in loadFormPage");
        model.addAttribute(NEWS_ARTICLE, new NewsArticle());
        return NEWS_ADMIN_PAGE;
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
    public String addNewsArticle(final HttpServletRequest request, final HttpServletResponse response,
            @ModelAttribute(NEWS_ARTICLE) @Valid final NewsArticle newsArticle, final BindingResult result, final Model model) {

        if (result.hasErrors()) {
            return NEWS_ADMIN_PAGE;
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

        return NEWS_PAGE;
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
    public String viewNewsArticles(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);

        model.addAttribute("mostPopular", getMostPopular());

        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        return NEWS_PAGE;
    }

    /**
     * deleteNewsArticle - removes the selected news story from the db.
     *
     * @param storyId
     * @param model
     * @return String - view to display
     */
    @RequestMapping(value = "/delete/{story_id:\\d+}", method = RequestMethod.GET)
    public String deleteNewsArticle(final HttpServletRequest request, @PathVariable("story_id") final Integer storyId, final Model model) {
        LOGGER.log(Level.INFO, "in deleteContact {0}", storyId);

        try {
            newsService.removeNewsArticles(storyId);
        } catch (ObjectNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Article to delete does not exist {0}", e.getMessage());
        }

        // Set the articleList attribute to null to force refresh of the PagedLstHolder
        request.getSession().setAttribute(ARTICLE_LIST, null);
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);
        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        // Redirect so page reloads
        return REDIRECT_NEWS;
    }

    /**
     * editArticle - locates the news article that was selected for editing from the id path variable that matches the
     * story_id of the article. Adds the article to be updated into the model and then returns the editNews view to load
     * the page with the article details pre-populated.
     *
     * @param id story_id of the news article to edit
     * @param model object to store the article in
     * @return editNews.jsp view
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable final Integer id, final Model model) {
        NewsArticle article = newsService.getArticle(id);
        model.addAttribute(NEWS_ARTICLE, article);

        return "editNews";
    }

    /**
     * updateArticle - updates the news article whose story_id matches that of the newsArticle passed in.
     *
     * @param newsArticle object that contains the updated values
     * @param model object to store the pageListholder in for pagination
     * @return articleDetails.jsp view
     */
    @RequestMapping(value = "/edit/update", method = RequestMethod.POST)
    public String updateArticle(@ModelAttribute final NewsArticle newsArticle, final Model model, final HttpServletRequest request) {
        newsService.editNewsArticle(newsArticle);
        request.getSession().setAttribute(ARTICLE_LIST, null);
        PagedListHolder<NewsArticle> pagedListHolder = populatePagedListHolder(request);

        request.getSession().setAttribute(ARTICLE_LIST, pagedListHolder);

        model.addAttribute(ARTICLE_LIST, pagedListHolder);

        return REDIRECT_NEWS;
    }

    /**
     * populatePagedListHolder - populates the Spring PagedListHolder class with the list of news stories in order to
     * handle the news story pagination. Retrieves the request object 'page' to determine which direction the navigation
     * of the pages should be processed.
     *
     * @param request
     * @return
     */
    private PagedListHolder<NewsArticle> populatePagedListHolder(final HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        PagedListHolder<NewsArticle> pagedListHolder =
                (PagedListHolder<NewsArticle>) request.getSession().getAttribute(ARTICLE_LIST);

        // If first time on page populate the pagedListHolder with the news articles
        if (pagedListHolder == null) {
            List<NewsArticle> articleList = newsService.listNewsArticles();
            LOGGER.log(Level.INFO, "articleList - articleList.size(): {0}", articleList.size());
            pagedListHolder = new PagedListHolder<NewsArticle>(articleList);
        } else {
            String page = request.getParameter("page");
            if ("next".equals(page)) {
                pagedListHolder.nextPage();
            } else if ("previous".equals(page)) {
                pagedListHolder.previousPage();
            }
        }

        return pagedListHolder;
    }

    /**
     * getMostPopular - returns list of most popular news stories to display in most popular column on news page
     *
     * @return List of most popular news stories
     */
    private List<NewsArticle> getMostPopular() {
        LOGGER.log(Level.INFO, "getMostPopular");
        return newsService.getMostPopular();
    }
}
