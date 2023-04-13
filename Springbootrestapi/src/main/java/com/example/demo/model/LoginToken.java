package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_tokens")
public class LoginToken {
	
	@Id
    private String userId;

    private String token;

    private LocalDateTime expirationTime;
	
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(LocalDateTime expirationTime) {
		this.expirationTime = expirationTime;
	}

	public LoginToken() {
		super();
	}

	
	public LoginToken(String userId2, String token2, LocalDateTime expirationTime2) {
		
	}

	@Override
	public String toString() {
		return "LoginToken [userId=" + userId + ", token=" + token + ", expirationTime=" + expirationTime + "]";
	}

    
    
}