package org.au.dynamicflame.news.service;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;

/**
 * NewsService.java - NewsService interface. Will handle CRUD operations of news articles.
 *
 * @author Alasdair
 * @since 19/01/2014
 */
public interface NewsService {
    /**
     * addNewsArticle - service method to add a single news article into the db
     *
     * @param newsArticle the article to be added
     */
    public void addNewsArticle(NewsArticle newsArticle);

    /**
     * listNewsArticles - service method to list all the news articles currently stored in descending order by the time they
     * were posted.
     *
     * @return the list of news articles
     */
    public List<NewsArticle> listNewsArticles();

    /**
     * removeNewsArticles - service method to remove a single news article from db specified by the id passed in.
     *
     * @param id (story_id) of the article to be removed
     */
    public void removeNewsArticles(Integer id);

    /**
     * editNewsArticle -  service method to update a news article with the values of the passed in newsArticle object.
     *
     * @param newsArticle the object to update
     */
    public void editNewsArticle(NewsArticle newsArticle);

    /**
     * getArticle -  service method to retrieve a single news article matching the given story id
     *
     * @param id (story_id) of the article to retrieve
     */
    public NewsArticle getArticle(Integer storyId);

    /**
     * getMostPopular -  service method to return the 3 most popular news articles based on number of likes
     *
     * @return list of popular news articles
     */
    public List<NewsArticle> getMostPopular();
}
