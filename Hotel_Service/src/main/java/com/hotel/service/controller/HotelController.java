package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.model.Hotel;
import com.hotel.service.serviceImpl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	public HotelServiceImpl hotelImpl;
	
	@PostMapping("/saveHotel")
	public  ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelImpl.create(hotel));
	}
	
	@GetMapping("/getAllHotel")
	public List<Hotel> getAllHotel(){
		return hotelImpl.getAllHotel();
	}

	@GetMapping("/getHotel/{id}")
	public Hotel getHotel(@PathVariable Integer id) {
		return hotelImpl.getHoste(id);
	}
	
	
	
}
