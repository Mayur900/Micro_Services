package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.model.User;
import com.user.service.servicesimpl.UserServiceImpl;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserServiceImpl userServiceImpl;

	@PostMapping(path = "/saveUser")
	public User saveUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}

	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return userServiceImpl.getAllUsers();
	}

	@GetMapping("/getUser/{id}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "rateLimiterHotelBreaker" , fallbackMethod = "ratingHotelFallback")
	public User getUser(@PathVariable int id) {
		return userServiceImpl.getUser(id);
	}

	public User ratingHotelFallback(int userId, Exception ex) {
		System.out.println("Fall Back Method Down " + ex.getMessage());
		User user = new User();
		user.setAbout(ex.getMessage());
		user.setUserName("ratingHotelBreaker");
		return user;
	}

	@GetMapping("/getUserWithParam")
	public User getUserWithParam(@RequestParam(required = false) int id) {
		return userServiceImpl.getUser(id);
	}

}
