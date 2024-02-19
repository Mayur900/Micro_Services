package com.rating.service.services;

import java.util.List;

import com.rating.service.model.Rating;

public interface RatingService {
	
	
	public Rating createRating(Rating rating);
	
	public List<Rating> getAllRating();
	
	public List<Rating> getRatingByUserId(String userId);
	
	public List<Rating> getRatingByHotelId(int hotelId);
	
	
}
