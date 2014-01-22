package org.au.dynamicflame.db;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * NewsServiceTest.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
public class NewsServiceTest {

    @Autowired
    private SessionFactory sessionFactory;
    
    protected FlushMode flushMode = FlushMode.MANUAL;

    protected void setUp() throws Exception {
//        Session session = getSession(this.sessionFactory);
//        TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(session));
//        System.out.println("Hibernate session is bound");
    }
    
//    protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
////        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
////        FlushMode flushMode = this.flushMode;
////        if (flushMode != null) {
////            session.setFlushMode(flushMode);
////        }
////        return session;
//    }

    protected void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testAddStory() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setTitle("title test");
        newsArticle.setSubtitle("subtitle test");
        newsArticle.setContent("content test");
        newsArticle.setAuthor("admin");
        short imageid = 1;
        newsArticle.setImage_id(imageid);
        
        session.save(newsArticle);
        session.getTransaction().commit();
        session.close();

    }
    
    @Test
    public void testGetStories() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        List<NewsArticle> result = session.createQuery("FROM NewsArticle").list();
        for (NewsArticle article : (List<NewsArticle>) result) {
            System.out.println("article " + article.getTitle());
        }
        
        session.getTransaction().commit();
        session.close();
    }
}
