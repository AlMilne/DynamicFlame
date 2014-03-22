package org.au.dynamicflame.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.au.dynamicflame.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SendEmailController.java - Controller the sending of emails from the contactus page. Makes use of the spring
 * JavaMailSender implementation * class
 *
 * @author Alasdair
 * @since 18/02/2014
 */
@Controller
@RequestMapping("/sendEmail")
@Configuration
@PropertySource("classpath:messages_en.properties")
public class SendEmailController {

    private static final Logger LOGGER = Logger.getLogger("SendEmailController");

    @Value("#{propSource[recipientAddress]}")
    private String recipientAddress;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    /**
     * doSendEmail - sends an email using the properties from set for the mailSender bean in spring-servlet.xml.
     *
     * @param HttpServletRequest request
     * @return String - view to display
     */
    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(@ModelAttribute("email") final Email email, final Model model) {
        LOGGER.log(Level.INFO, "email: {0}", email);

        boolean success = true;

        // takes input from e-mail form
        String subject = email.getSubject();
        String message = email.getMessage();
        String yourEmail = email.getYourEmail();

        // prints debug info
        LOGGER.log(Level.INFO, "To: {0}", recipientAddress);
        LOGGER.log(Level.INFO, "Senders Email: {0}", yourEmail);
        LOGGER.log(Level.INFO, "Subject: {0}", subject);
        LOGGER.log(Level.INFO, "Message: {0}", message);

        // creates a simple e-mail object
        SimpleMailMessage simpleEmail = new SimpleMailMessage();
        simpleEmail.setTo(recipientAddress);
        simpleEmail.setFrom(yourEmail);
        simpleEmail.setSubject(subject);
        simpleEmail.setText(message);

        try {
            // sends the e-mail
            mailSender.send(simpleEmail);
        } catch (MailSendException me) {
            success = false;
            LOGGER.log(Level.INFO, "Email failure {0}", me.getMessage());
        }

        if(success) {
            model.addAttribute("emailResult", env.getProperty("email.success"));
        } else {
            model.addAttribute("emailResult", env.getProperty("email.failure"));
        }

        // forwards to the view named contact
        return "emailThanks";
    }

    /**
     * @return the mailSender
     */
    public JavaMailSender getMailSender() {
        return mailSender;
    }

    /**
     * @param mailSender the mailSender to set
     */
    public void setMailSender(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
