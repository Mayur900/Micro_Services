package com.user.service.servicesimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.model.Hotel;
import com.user.service.model.Rating;
import com.user.service.model.User;
import com.user.service.repositry.UserServiceRepositry;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemp;
	
	@Autowired
	public UserServiceRepositry userServiceRepositry;
	
	@Override
	public User saveUser(User user) {
		return userServiceRepositry.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = userServiceRepositry.findAll();
		
		list.forEach(s -> {
			ArrayList<Rating> userList = restTemp.getForObject("http://Rating-Service/getRatingByUserId/"+s.getUserId(), ArrayList.class);
			s.setRating(userList);
		});
		return list; 
		
	}

	@Override
	public User getUser(int id) {
		User user =  userServiceRepositry.findById(id).get();
		@SuppressWarnings("unchecked")
		Rating[] RList = restTemp.getForObject("http://Rating-Service/getRatingByUserId/"+id, Rating[].class);
		
		List<Rating> list = Arrays.stream(RList).collect(Collectors.toList());
		
		list.forEach(p -> {
			ResponseEntity<Hotel> hotel = restTemp.getForEntity("http://Hotel-Service/getHotel/"+p.getHotelId(), Hotel.class);
			p.setHotel(hotel.getBody());
		});
		user.setRating(list);
		return user;
	}

}
