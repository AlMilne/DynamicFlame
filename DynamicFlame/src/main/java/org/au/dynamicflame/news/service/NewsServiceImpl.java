package org.au.dynamicflame.news.service;

import java.util.List;

import javax.transaction.Transactional;

import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.dao.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NewsServiceImpl.java - Service layer class for the news service.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
@Service  
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;
    
    /** 
     * {@inheritDoc}
     */
    @Override
    public void addNewsArticle(NewsArticle newsArticle) {
        newsDAO.addNewsArticle(newsArticle);
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public List<NewsArticle> listNewsArticles() {
        System.err.println("listNewsArticles listNewsArticles listNewsArticles");
        return newsDAO.listNewsArticles();
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void removeNewsArticles(Integer id) {
        newsDAO.removeNewsArticles(id);
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void editNewsArticle(NewsArticle newsArticle) {
        newsDAO.editNewsArticle(newsArticle);
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public NewsArticle getArticle(Integer storyId) {
        return newsDAO.getArticle(storyId);
    }

}
