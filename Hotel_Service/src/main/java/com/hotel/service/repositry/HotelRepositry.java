package com.hotel.service.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.service.model.Hotel;

@Repository
public interface HotelRepositry extends JpaRepository<Hotel, Integer> {

}
