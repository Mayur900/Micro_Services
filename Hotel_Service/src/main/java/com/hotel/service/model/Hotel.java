package com.hotel.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "micro_hotel")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	private String name;
	private String location;
	private String about;
	
	
	
	
}
