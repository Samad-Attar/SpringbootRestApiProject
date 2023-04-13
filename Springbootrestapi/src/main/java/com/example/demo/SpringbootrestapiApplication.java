package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class SpringbootrestapiApplication {
	@Bean
    public JavaMailSender javaMailSender() { 
          return new JavaMailSenderImpl();
          }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestapiApplication.class, args);   
		
	    
		
	}

}
