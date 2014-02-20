package org.au.dynamicflame.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.au.dynamicflame.controllers.DefaultController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * DefultControllerTest.java - tests for default controller
 * 
 * @author Alasdair
 * @since 16/02/2014
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
public class DefaultControllerTest {
    
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private DefaultController defaultController = new DefaultController();
    
    @Autowired MockHttpSession session;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testHandleRequestView() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    
    @Test
    public void testHandleRequestIndex() throws Exception {
        mockMvc.perform(get("/index.html")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    
    @Test
    public void testHandleRequestMelville() throws Exception {
        mockMvc.perform(get("/melville.html")).andExpect(status().isOk()).andExpect(view().name("melville"));
    }
    
    @Test
    public void testHandleRequestCannington() throws Exception {
        mockMvc.perform(get("/cannington.html")).andExpect(status().isOk()).andExpect(view().name("cannington"));
    }
    
    @Test
    public void testHandleRequestHainsworth() throws Exception {
        mockMvc.perform(get("/hainsworth.html")).andExpect(status().isOk()).andExpect(view().name("hainsworth"));
    }
    
    @Test
    public void testHandleRequestCurtin() throws Exception {
        mockMvc.perform(get("/curtin.html")).andExpect(status().isOk()).andExpect(view().name("curtin"));
    }
    
    @Test
    public void testHandleRequestVicpark() throws Exception {
        mockMvc.perform(get("/vicpark.html")).andExpect(status().isOk()).andExpect(view().name("vicpark"));
    }
    
    @Test
    public void testHandleRequestLangford() throws Exception {
        mockMvc.perform(get("/langford.html")).andExpect(status().isOk()).andExpect(view().name("langford"));
    }
    
    @Test
    public void testHandleRequestHeathridge() throws Exception {
        mockMvc.perform(get("/heathridge.html")).andExpect(status().isOk()).andExpect(view().name("heathridge"));
    }
    
    @Test
    public void testHandleRequestKingsway() throws Exception {
        mockMvc.perform(get("/kingsway.html")).andExpect(status().isOk()).andExpect(view().name("kingsway"));
    }
    
    @Test
    public void testHandleRequestPhotos() throws Exception {
        mockMvc.perform(get("/photos.html")).andExpect(status().isOk()).andExpect(view().name("photos"));
    }
    
    @Test
    public void testHandleRequestAbout() throws Exception {
        mockMvc.perform(get("/about.html")).andExpect(status().isOk()).andExpect(view().name("about"));
    }
    
    @Test
    public void testHandleRequestContact() throws Exception {
        mockMvc.perform(get("/contact.html")).andExpect(status().isOk()).andExpect(view().name("contact"));
    }
    
}
