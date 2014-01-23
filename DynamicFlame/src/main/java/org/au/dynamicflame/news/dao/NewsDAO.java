package org.au.dynamicflame.news.dao;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;

/**
 * NewsDAO.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
public interface NewsDAO {
    public void addNewsArticle(NewsArticle newsArticle);

    public List<NewsArticle> listNewsArticles();

    public void removeNewsArticles(Integer id);
    
}
