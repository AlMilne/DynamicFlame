package org.au.dynamicflame.news.dao;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;

/**
 * NewsDAO.java - DAO interface for the news articles
 *
 * @author Alasdair
 * @since 19/01/2014
 */
public interface NewsDAO {

    /**
     * addNewsArticle - adds a single news article into the db
     *
     * @param newsArticle the article to be added
     */
    void addNewsArticle(NewsArticle newsArticle);

    /**
     * listNewsArticles - returns a list of all the news articles currently stored in descending order by the time they
     * were posted.
     *
     * @return the list of news articles
     */
    List<NewsArticle> listNewsArticles();

    /**
     * removeNewsArticles - removes a single news article from db specified by the id passed in.
     *
     * @param id (story_id) of the article to be removed
     */
    void removeNewsArticles(Integer id);

    /**
     * editNewsArticle - edits or updates a news article with the values of the passed in newsArticle object.
     *
     * @param newsArticle the object to update
     */
    void editNewsArticle(NewsArticle newsArticle);

    /**
     * getArticle - retrieves a single news article matching the given story id
     *
     * @param id (story_id) of the article to retrieve
     */
    NewsArticle getArticle(Integer storyId);

    /**
     * getMostPopular - returns the 3 most popular news articles based on number of likes
     *
     * @return list of popular news articles
     */
    List<NewsArticle> getMostPopular();

}
