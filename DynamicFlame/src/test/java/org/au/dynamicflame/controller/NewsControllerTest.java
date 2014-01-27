package org.au.dynamicflame.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Alasdair
 * @since 11/01/2014
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
public class NewsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private NewsController newsController = new NewsController();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        // InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // viewResolver.setPrefix("/WEB-INF/jsp/view/");
        // viewResolver.setSuffix(".jsp");
        // mockMvc = MockMvcBuilders.standaloneSetup(newsController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testHandleRequestView() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("newsAdmin"))
                .andExpect(model().attributeExists("newsArticle"));
    }

    @Test
    public void testProcessNewsArticleValidationError() throws Exception {
        mockMvc.perform(post("/articleDetails")).andExpect(status().isOk()).andExpect(view().name("newsAdmin"));
    }

    @Test
    public void testProcessNewsArticleSuccess() throws Exception {
        mockMvc.perform(post("/articleDetails").param("title", "title").param("content", "content").param("subtitle", "subtitle"))
                .andExpect(status().isOk()).andExpect(view().name("articleDetails"))
                .andExpect(model().attributeExists("articleList"));
    }
    
    @Test
    public void testViewNewsArticles() throws Exception {
        mockMvc.perform(get("/articleDetails"))
                .andExpect(status().isOk()).andExpect(view().name("articleDetails"))
                .andExpect(model().attributeExists("articleList"));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteNewsArticles() throws Exception {
        mockMvc.perform(get("/delete/59"))
                .andExpect(status().isMovedTemporarily()).andExpect(view().name("redirect:/articleDetails"))
                .andExpect(model().attributeExists("articleList"));
    }
    
}
