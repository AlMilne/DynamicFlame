package org.au.dynamicflame.news.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.au.dynamicflame.model.NewsArticle;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * NewsDAOImpl.java - Implementation of the NewsDAO class to handle the adding, listing and deletion of news stories.
 * Uses the Hibernate sessionFactory to perform the necessary operations on each of these methods to interact with the
 * db.
 *
 * @author Alasdair
 * @since 19/01/2014
 */
@Repository
public class NewsDAOImpl implements NewsDAO {
    private static final Logger LOGGER = Logger.getLogger("NewsDAOImpl");

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public void addNewsArticle(final NewsArticle newsArticle) {
        sessionFactory.getCurrentSession().save(newsArticle);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void editNewsArticle(final NewsArticle newsArticle) {
        LOGGER.log(Level.INFO, "newsArticle: {0}", newsArticle.getStoryId());

        // Retrieve the article from db that is to be updated
        NewsArticle articleToUpdate =
                (NewsArticle) sessionFactory.getCurrentSession().load(NewsArticle.class, newsArticle.getStoryId());

        // Set the article values to be updated
        if (null != articleToUpdate) {
            articleToUpdate.setTitle(newsArticle.getTitle());
            articleToUpdate.setSubtitle(newsArticle.getSubtitle());
            articleToUpdate.setContent(newsArticle.getContent());

            sessionFactory.getCurrentSession().update(articleToUpdate);
        } else {
            LOGGER.log(Level.SEVERE, "no article to update found");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NewsArticle getArticle(final Integer storyId) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM NewsArticle where story_id = :storyId");
        query.setParameter("storyId", storyId);

        return (NewsArticle) query.list().get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<NewsArticle> getMostPopular() {
        return sessionFactory.getCurrentSession().createQuery("FROM NewsArticle order by likes desc").setMaxResults(3).list();
    }

}
