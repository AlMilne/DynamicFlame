package org.au.dynamicflame.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.au.dynamicflame.controllers.SendEmailController;
import org.au.dynamicflame.model.Email;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
@Ignore("tired of spamming own email")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
public class SendEmailControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockHttpSession session;

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private SendEmailController sendEmailController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * Test method for {@link SendEmailController#doSendEmail()} .
     */
    @Test
    public void testSendEmail() throws Exception {
        session.setAttribute("email", new Email());

        mockMvc.perform(
                post("/sendEmail").session(session).param("recipient", "alasdair.milne@yahoo.co.uk").param("subject", "subject")
                        .param("message", "message")).andExpect(status().isOk()).andExpect(view().name("emailThanks"));
    }
}
