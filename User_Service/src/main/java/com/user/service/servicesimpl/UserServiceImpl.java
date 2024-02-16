package com.user.service.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.model.User;
import com.user.service.repositry.UserServiceRepositry;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserServiceRepositry userServiceRepositry;
	
	@Override
	public User saveUser(User user) {
		return userServiceRepositry.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userServiceRepositry.findAll();
	}

	@Override
	public User getUser(int id) {
		return userServiceRepositry.findById(id).get();
	}

}
