package com.rating.service.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.service.model.Rating;

@Repository
public interface RatingRepositry extends JpaRepository<Rating, Integer> {

	public	List<Rating> findByUserId(String userId);

	public List<Rating> findByHotelId(int hotelId);

}
