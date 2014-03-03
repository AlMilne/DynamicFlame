package org.au.dynamicflame.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.transaction.Transactional;

import org.au.dynamicflame.controllers.NewsController;
import org.au.dynamicflame.model.NewsArticle;
import org.au.dynamicflame.news.service.NewsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * NewsControllerTest.java - test class for NewsController class.
 *
 * TODO: verify calling of newsServiceMock object, currently using real NewsController and not a mock
 *
 * @author Alasdair
 * @since 11/01/2014
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
public class NewsControllerTest {

    private static int TEST_ARTICLE_ID = 67;

    private MockMvc mockMvc;

    @Mock
    private NewsService newsService;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private final NewsController newsController = new NewsController();

    @Autowired MockHttpSession session;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        session.setAttribute("newsArticle", new NewsArticle());

        // InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // viewResolver.setPrefix("/WEB-INF/jsp/view/");
        // viewResolver.setSuffix(".jsp");
        // mockMvc = MockMvcBuilders.standaloneSetup(newsController).setViewResolvers(viewResolver).build();
    }

    /**
     * Test method for {@link NewsController#loadFormPage()} .
     */
    @Test
    public void testLoadFormPage() throws Exception {
        mockMvc.perform(get("/newsAdmin")).andExpect(status().isOk()).andExpect(view().name("newsAdmin"))
                .andExpect(model().attributeExists("newsArticle"));
    }

    /**
     * Test method for {@link NewsController#viewNewsArticles()} .
     */
    @Test
    public void testProcessNewsArticleValidationError() throws Exception {
        mockMvc.perform(post("/news").session(session)).andExpect(status().isOk())
                .andExpect(model().attributeExists("newsArticle"))
                .andExpect(model().attributeHasFieldErrors("newsArticle", "title")).andExpect(view().name("newsAdmin"));

     //   verifyZeroInteractions(newsServiceMock);
    }

    /**
     * Test method for {@link NewsController#processNewsArticle()} .
     */
    @Test
    @Transactional
    @Rollback(true)
    public void testProcessNewsArticleSuccess() throws Exception {
        short s = 1;

        NewsArticle article = new NewsArticle();
        article.setTitle("title");
        article.setContent("content");
        article.setSubtitle("subtitle");

        mockMvc.perform(
                post("/news").session(session).sessionAttr("newsArticle", article))
                .andExpect(status().isOk())
                .andExpect(view().name("news"))
                .andExpect(model().attributeExists("articleList"))
                .andExpect(
                        model().attribute(
                                "newsArticle",
                                allOf(hasProperty("author", is("admin")), hasProperty("imageId", is(s)),
                                        hasProperty("title", is("title")), hasProperty("content", is("content")),
                                        hasProperty("subtitle", is("subtitle")))));

       // verify(newsServiceMock, times(1)).addNewsArticle(Mockito.any(NewsArticle.class));
     //   verifyNoMoreInteractions(newsServiceMock);
    }

    /**
     * Test method for {@link NewsController#viewNewsArticles()} .
     */
    @Test
    public void testViewNewsArticles() throws Exception {
        mockMvc.perform(get("/news")).andExpect(status().isOk()).andExpect(view().name("news"))
                .andExpect(model().attributeExists("articleList"));
    }

    /**
     * Test method for {@link NewsController#editArticle()} .
     */
    @Test
    public void testEditArticle() throws Exception {
        mockMvc.perform(get("/edit/" + TEST_ARTICLE_ID)).andExpect(status().isOk()).andExpect(view().name("editNews"))
                .andExpect(model().attributeExists("newsArticle"));
    }



    /**
     * Test method for {@link NewsController#deleteNewsArticle()} .
     */
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteNewsArticles() throws Exception {
        mockMvc.perform(get("/delete/" + TEST_ARTICLE_ID)).andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/news")).andExpect(model().attributeExists("articleList"));

       // verify(newsServiceMock, times(1)).removeNewsArticles(TEST_ARTICLE_ID);
     //   verifyNoMoreInteractions(newsServiceMock);
    }

    /**
     * Test method for {@link NewsController#deleteNewsArticle()} .
     */
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteNewsArticlesNullArticle() throws Exception {
        mockMvc.perform(get("/delete/" + 5000)).andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/news")).andExpect(model().attributeExists("articleList"));

       // verify(newsServiceMock, times(1)).removeNewsArticles(TEST_ARTICLE_ID);
     //   verifyNoMoreInteractions(newsServiceMock);
    }

    /**
     * Test method for {@link NewsController#updateArticle()} .
     */
    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateArticle() throws Exception {
        NewsArticle article = new NewsArticle();
        article.setStoryId(TEST_ARTICLE_ID);
        article.setAuthor("admin");
        article.setTitle("title");
        article.setSubtitle("subtitle");
        article.setContent("content");
        session.setAttribute("newsArticle", article);

        mockMvc.perform(post("/edit/update").session(session)).andExpect(status().isMovedTemporarily())
            .andExpect(view().name("redirect:/news")).andExpect(model().attributeExists("articleList"))
            .andExpect(model().attributeExists("newsArticle"));
    }

}
