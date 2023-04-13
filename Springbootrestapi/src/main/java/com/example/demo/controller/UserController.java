package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginToken;
import com.example.demo.model.User;
import com.example.demo.service.LoginTokenService;
import com.example.demo.service.UserService;

@RestController

public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private LoginTokenService loginTokenService;

    @Autowired
    private JavaMailSender javaMailSender;
	

    @PostMapping("/login")
    public ResponseEntity<?> generateLoginToken(@RequestParam("userId") String userId) {
        // Check if user exists
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Generate login token and save to database
           // LoginTokenService loginTokenService = null;
			LoginToken loginToken = loginTokenService.generateLoginToken(userId);
            // Send login link to user's registered email
            String loginLink = "http://localhost:8080/api/users/login?userId=" + userId + "&token=" + loginToken.getToken();
            String subject = "Login Link for " + user.getName();
            String message = "Hello " + user.getName() + ",\n\nYour login link is:\n\n" + loginLink + "\n\nThis link will expire in 15 minutes.";
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(user.getEmail());
            email.setSubject(subject);
            email.setText(message);
          // JavaMailSender javaMailSender = null;
			javaMailSender.send(email);
            return ResponseEntity.ok("Login link sent to " + user.getEmail());
        } else {
            return ResponseEntity.badRequest().body("User not found with");}}
	
	
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id")Long id) 
	{
		return 	userService.getSingleUser(id);
	}
	
	
	/*@PostMapping("/users")
	public User saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
		
	}	*/
	
	@PutMapping("/users/{id}")
	public User getUser(@PathVariable("id")Long id, @RequestBody User user) {
		user.setId(id);
		return userService.updateUser(user);
		}
	
	@DeleteMapping("/users")
	public void deleteUser(@RequestParam("id")Long id) {
		userService.deleteUser(id);
		}
	 @PostMapping("/users")
	    public ResponseEntity<User> registerUser(@RequestBody User user) {
	        User registeredUser = userService.registerUser(user);
	        return ResponseEntity.ok(registeredUser);
	    }
}
