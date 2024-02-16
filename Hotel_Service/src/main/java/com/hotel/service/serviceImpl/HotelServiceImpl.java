package com.hotel.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.model.Hotel;
import com.hotel.service.repositry.HotelRepositry;
import com.hotel.service.services.hotelService;

@Service
public class HotelServiceImpl implements hotelService {

	@Autowired
	public HotelRepositry hotelRepositry;

	@Override
	public Hotel create(Hotel hotel) {
		return hotelRepositry.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepositry.findAll();
	}

	@Override
	public Hotel getHoste(Integer id) {
		return hotelRepositry.findById(id).get();
	}
	
	
	
	
}
