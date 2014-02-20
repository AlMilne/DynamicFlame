package org.au.dynamicflame.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.au.dynamicflame.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SendEmailController.java - Controller the sending of emails from the contactus page. Makes use of the spring JavaMailSender implementation * class
 * 
 * @author Alasdair
 * @since 18/02/2014
 */  
@Controller
@RequestMapping("/sendEmail") 
public class SendEmailController { 

	private static final Logger LOGGER = Logger.getLogger("SendEmailController");
  
    @Autowired
    private JavaMailSender mailSender; 
    
	/**
     * doSendEmail - sends an email using the properties from set for the mailSender bean in spring-servlet.xml.
     * 
     * @param HttpServletRequest request
     * @return String - view to display
     */
    @RequestMapping(method = RequestMethod.POST) 
    public String doSendEmail( @ModelAttribute("email") Email email) { 
        LOGGER.log(Level.INFO, "email: {0}", email);
        
        
        // takes input from e-mail form 
        String recipientAddress = email.getRecipient(); 
        String subject = email.getSubject();  
        String message = email.getMessage();
          
        // prints debug info 
		LOGGER.log(Level.INFO, "To: {0}", recipientAddress);
		LOGGER.log(Level.INFO, "Subject: {0}", subject);
		LOGGER.log(Level.INFO, "Message: {0}", message);
          
        // creates a simple e-mail object 
        SimpleMailMessage simpleEmail = new SimpleMailMessage(); 
        simpleEmail.setTo(recipientAddress); 
        simpleEmail.setFrom(recipientAddress); 
        simpleEmail.setSubject(subject); 
        simpleEmail.setText(message); 
          
        // sends the e-mail 
        mailSender.send(simpleEmail); 
          
        // forwards to the view named contact 
        return "emailThanks"; 
    } 
}
