package com.user.service.services;

import java.util.List;

import com.user.service.model.User;

public interface UserService {
	
	
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(int id);
	
	

}
