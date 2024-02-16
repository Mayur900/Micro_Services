package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.model.User;
import com.user.service.servicesimpl.UserServiceImpl;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {

	@Autowired
	public UserServiceImpl userServiceImpl;
	
	
	@PostMapping(path =  "/saveUser")
	public  User saveUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}

	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userServiceImpl.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id){
		return userServiceImpl.getUser(id);
	}
	
	@GetMapping("/getUserWithParam")
	public User getUserWithParam(@RequestParam("id") int id){
		return userServiceImpl.getUser(id);
	}
	
}
