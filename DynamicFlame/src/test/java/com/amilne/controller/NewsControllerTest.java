package com.amilne.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.au.dynamicflame.controller.NewsController;
/**
 * NewsControllerTest.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 11/01/2014
 */
public class NewsControllerTest {

    @Test
    public void testHandleRequestView() throws Exception{
        NewsController controller = new NewsController();
        ModelAndView modelAndView = controller.handleRequest();
        assertEquals("newsAdmin", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("message");
        assertNotNull(nowValue);
    }
}
