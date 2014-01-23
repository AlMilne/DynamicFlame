package org.au.dynamicflame.db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.service.NewsService;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * NewsServiceTest.java - Test class for testing the newsService. Will test CRUD operations on dynamicflame database
 * using the newService methods.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
@TransactionConfiguration(defaultRollback=true)
public class NewsServiceTest {

    @Autowired
    private SessionFactory sessionFactory;

    protected FlushMode flushMode = FlushMode.MANUAL;

    @Autowired
    private NewsService newsService;

    protected void setUp() throws Exception {
        // Session session = getSession(this.sessionFactory);
        // TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(session));
        // System.out.println("Hibernate session is bound");
    }

    // protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
    // // Session session = SessionFactoryUtils.getSession(sessionFactory, true);
    // // FlushMode flushMode = this.flushMode;
    // // if (flushMode != null) {
    // // session.setFlushMode(flushMode);
    // // }
    // // return session;
    // }

    protected void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    @Rollback(true)
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

        newsService.addNewsArticle(newsArticle);

        // session.save(newsArticle);
        session.flush();
        // session.getTransaction().commit();
        session.close();

    }

    @Test
    public void testGetStories() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<NewsArticle> result = newsService.listNewsArticles();

        assertEquals("New story test", result.get(0).getTitle());

        for (NewsArticle article : (List<NewsArticle>) result) {
            System.out.println("article " + article.getTitle());
        }

        session.flush();

        session.close();
    }
    
    @Test
    public void testRemoveStory() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        newsService.removeNewsArticles(5);
        
        session.flush();

        session.close();
    }
}
