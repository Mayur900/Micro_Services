package com.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.model.Hotel;

@FeignClient(name = "Hotel-Service")
public interface HotelService {
	
	@GetMapping("/hotels/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable int hotelId);

}
