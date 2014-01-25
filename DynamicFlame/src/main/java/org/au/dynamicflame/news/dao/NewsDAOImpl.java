package org.au.dynamicflame.news.dao;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * NewsDAOImpl.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
@Repository
public class NewsDAOImpl implements NewsDAO {
    
    @Autowired  
    private SessionFactory sessionFactory;  
      
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  

    /** 
     * {@inheritDoc}
     */
    @Override
    public void addNewsArticle(NewsArticle newsArticle) {
        getCurrentSession().save(newsArticle); 
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public List<NewsArticle> listNewsArticles() {
        return sessionFactory.getCurrentSession().createQuery("FROM NewsArticle order by posted_time desc").list();
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void removeNewsArticles(final Integer id) {
        NewsArticle newsArticle = (NewsArticle) sessionFactory.getCurrentSession().load(NewsArticle.class, id);
        if (null != newsArticle) {
            sessionFactory.getCurrentSession().delete(newsArticle);
        }
        
    }

}
