package org.au.dynamicflame.news.service;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;

/**
 * NewsService.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
public interface NewsService {
    public void addNewsArticle(NewsArticle newsArticle);

    public List<NewsArticle> listNewsArticles();

    public void removeNewsArticles(Integer id);
}
