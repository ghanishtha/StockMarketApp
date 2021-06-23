package com.example.demo.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.response.Response;
import com.example.demo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	String myMail = "faltutimepass71@gmail.com";
	String myPassword = "Pass@12345";
	String URL = "http://localhost:8080/confirmUser/";
	
	@GetMapping("/confirmUser/{id}")
	public String confirmUser(@PathVariable int id) {
		User user = service.findById(id);
		user.setConfirmed(true);
		User tempUser = service.saveUser(user);
		if(tempUser!=null) {
			return "Verified";
		}
		return "Sorry! We are having some trouble!";
	}
	
	@PostMapping("/register")
	public Response registerUser(@RequestBody User user) throws AddressException, MessagingException {
		
		boolean isEmailUnique = service.isEmailUnique(user.getEmail());
		if(!isEmailUnique) {
			return new Response(false, "Please use a different Email!");
		}
		
		boolean isUsernameUnique = service.isUserNameUnique(user.getUsername());
		if(!isUsernameUnique) {
			return new Response(false, "Please use a different Username!");
		}
		
		boolean isMobileUnique = service.isMobileUnique(user.getMobileNumber());
		if(!isMobileUnique) {
			return new Response(false, "Please use a different Mobile Number!");
		}
		
		User savedUser = service.saveUser(user);
		if(savedUser!=null) {
			sendEmail(savedUser.getId());
			return new Response(true, "User created. Confirm your email to complete registration!");
		}
		
		return new Response(false, "Sorry, We ran into some problem.");
				
	}
	
	public void sendEmail(int id) throws AddressException, MessagingException {
		
		User user = service.findById(id);
		
		final String username = myMail;
		final String password = myPassword;
		final String userEmail = user.getEmail();
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
			
		});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myMail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			
			message.setSubject("User confirmation");
			message.setContent(
					"<h1><a href =" + "\"" + URL + Integer.toString(id) + "/" + "\"" + "> Click to confirm </a></h1>",
				"text/html");
			
			Transport.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
