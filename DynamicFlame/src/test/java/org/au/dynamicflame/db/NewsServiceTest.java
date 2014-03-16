package org.au.dynamicflame.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
    private NewsService newsService;

    protected void tearDown() throws Exception {
    }

    /**
     * Test method for {@link NewsService#addNewsArticle(newsArticle)} .
     */
    @Test
    @Rollback(true)
    public void testAddStory() {
        List<NewsArticle> result = newsService.listNewsArticles();
        int count = result.size();

        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setTitle("test");
        newsArticle.setSubtitle("subtitle");
        newsArticle.setContent("content");
        newsArticle.setAuthor("admin");
        short imageid = 1;
        newsArticle.setImageId(imageid);

        newsService.addNewsArticle(newsArticle);

        assertEquals(count+1, newsService.listNewsArticles().size());
    }

    /**
     * Test method for {@link NewsService#listNewsArticles()} .
     */
    @Test
    public void testGetStories() {
        List<NewsArticle> result = newsService.listNewsArticles();

        assertNotNull(result.get(0).getTitle());
    }

    /**
     * Test method for {@link NewsService#removeNewsArticles(int)} .
     */
    @Test
    @Rollback(true)
    public void testRemoveStory() {

        List<NewsArticle> result = newsService.listNewsArticles();
        int count = result.size();

        newsService.removeNewsArticles(5);

        assertEquals(count-1, newsService.listNewsArticles().size());
    }
}
