package org.au.dynamicflame.model;

/**
 * Email.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 19/02/2014
 */
public class Email {

    private String recipient;
    private String subject;
    private String message;
    /**
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }
    /**
     * @param recipient the recipient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }
    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
