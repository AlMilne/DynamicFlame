package com.au.dynamicflame.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * NewsValidator.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 11/01/2014
 */
public class NewsArticleValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger("NewsArticleValidator");

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(final Class<?> clazz) {
        return NewsArticle.class.equals(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(Object obj, Errors errors) {
        NewsArticle news = (NewsArticle) obj;
        if (news == null) {
            errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
        } else {
            LOGGER.log(Level.INFO, "Validating with " + news + ": " + news.getTitle());
        }
    }

}
