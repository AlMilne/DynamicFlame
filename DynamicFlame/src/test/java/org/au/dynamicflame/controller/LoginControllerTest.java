package org.au.dynamicflame.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
 * LoginControllerTest.java - tests for LoginController.java
 *
 * @author Alasdair
 * @since 16/02/2014
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
public class LoginControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    private final DefaultController defaultController = new DefaultController();

    @Autowired
    MockHttpSession session;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testShouldLoginSuccessfully() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }

    @Test
    public void testShouldDisplayErrorOnLoginFailure() throws Exception {
        mockMvc.perform(get("/loginfailed")).andExpect(status().isOk()).andExpect(view().name("login"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    public void testShouldBeAbleToLogout() throws Exception {
        mockMvc.perform(get("/logout")).andExpect(status().isMovedTemporarily()).andExpect(view().name("redirect:/news"));
    }
}
