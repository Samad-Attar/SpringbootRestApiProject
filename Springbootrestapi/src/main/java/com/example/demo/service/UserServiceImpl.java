package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uRepository;
	
	
	@Override
	public List<User> getUsers() {
		
		return uRepository.findAll();
	}


/*	@Override
	public User saveUser(User user) {
		
		return uRepository.save(user);
	}

*/
	@Override
	public User getSingleUser(Long id) {
		
		 Optional <User>user =uRepository.findById(id);
		 if(user.isPresent()) {
			 
			 return user.get();
		 }
		 
		 throw new RuntimeException("user is not found for id"+id);
		 
		 
		 }

	@Override
	public void deleteUser(Long id) {
		
		 uRepository.deleteById(id);
	}

    @Override
	public User updateUser(User user) {
		return uRepository.save(user);
	}


	@Override
	public User registerUser(User user) {
		// Generate UserID using UUID
        String userid = UUID.randomUUID().toString();
        user.setUserid(userid);
        // Save user to database
        
        return uRepository.save(user);
		
	}


	@Override
	public Optional<User> getUserById(String userId) {
	
		return uRepository.findUserById(userId);
	}
}
