package org.au.dynamicflame.model;

/**
 * Email.java - Model class for email message, used on Contact us page.s
 *
 * @author Alasdair
 * @since 19/02/2014
 */
public class Email {

    private String yourEmail;
    private String subject;
    private String message;

    /**
     * @return the yourEmail
     */
    public String getYourEmail() {
        return yourEmail;
    }
    /**
     * @param yourEmail the yourEmail to set
     */
    public void setYourEmail(final String yourEmail) {
        this.yourEmail = yourEmail;
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
    public void setSubject(final String subject) {
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
    public void setMessage(final String message) {
        this.message = message;
    }
}
