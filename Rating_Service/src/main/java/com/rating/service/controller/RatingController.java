package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.model.Rating;
import com.rating.service.serviceImpl.RatingServiceImpl;

@RestController
public class RatingController {

	@Autowired
	public RatingServiceImpl ratingService;

	@PostMapping("createRating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.createRating(rating));
	}

	@GetMapping("getAllRatng")
	public List<Rating> getAllRating() {
		return ratingService.getAllRating();
	}

	@GetMapping("getRatingByUserId/{userId}")
	public List<Rating> getRatingByUserId(@PathVariable String userId) {
		return ratingService.getRatingByUserId(userId);
	}
	
	@GetMapping("getRatingByHotelId/{hotelId}")
	public List<Rating> getRatingByHotelId(@PathVariable int hotelId) {
		return ratingService.getRatingByHotelId(hotelId);
	}
	
}
