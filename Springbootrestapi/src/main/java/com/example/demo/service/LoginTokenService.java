package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginToken;
import com.example.demo.repository.LoginTokenRepository;

@Service
public class LoginTokenService {
    @Autowired
    private LoginTokenRepository loginTokenRepository;

    public LoginToken generateLoginToken(String userId) {
        // Generate token using UUID
        String token = UUID.randomUUID().toString();
        // Set expiration time to 15 minutes from now
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(15);
        // Save login token to database
        LoginToken loginToken = new LoginToken(userId, token, expirationTime);
        return loginTokenRepository.save(loginToken);
    }

    public boolean isTokenValid(String userId, String token) {
        // Get login token from database using UserID
        Optional<LoginToken> loginTokenOptional = loginTokenRepository.findById(userId);
        if (loginTokenOptional.isPresent()) {
            LoginToken loginToken = loginTokenOptional.get();
            // Check if token matches and is still valid
            if (loginToken.getToken().equals(token) && LocalDateTime.now().isBefore(loginToken.getExpirationTime())) {
                // Delete login token from database if it is still valid
                loginTokenRepository.deleteById(userId);
                return true;
            }
        }
        return false;
    }
}