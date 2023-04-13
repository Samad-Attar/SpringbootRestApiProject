package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	List<User>getUsers();

	
	//User saveUser(User user);
	User getSingleUser(Long id);
	void deleteUser(Long id);
	User updateUser(User user);
	User registerUser(User user);
    Optional<User> getUserById(String userId);
	
	
	
	
	
}
