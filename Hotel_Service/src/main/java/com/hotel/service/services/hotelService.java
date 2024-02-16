package com.hotel.service.services;

import java.util.List;

import com.hotel.service.model.Hotel;

public interface hotelService {
	
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHoste(Integer id);
	
	

}
