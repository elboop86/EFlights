package com.example;


import com.example.entities.Flight;
import com.example.repository.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class EFlightsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(EFlightsApplication.class, args);

		var flightRepo = context.getBean(FlightRepository.class);

		Flight f1 = new Flight( null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200, null);

		Flight f2 = new Flight(null,
				"AIRFORCE1",
				"BCN",
				"PAL",
				LocalDateTime.now().plusDays(0),
				LocalDateTime.now().plusDays(0).plusHours(0),
				150,
				null);

		Flight f3 = new Flight(null,
				"BOING 707",
				"MAD",
				"HON",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(12),
				350,
				null);

		Flight f4 = new Flight(null,
				"JET 1001",
				"LIMA",
				"NOR",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				450,
				null);

		Flight f5 = new Flight(null,
				"SPACING 300",
				"ARG",
				"BRA",
				LocalDateTime.now().plusDays(0),
				LocalDateTime.now().plusDays(0).plusHours(1),
				395,
				null);

		flightRepo.saveAll(List.of(f1,f2, f3, f4, f5));





	}



}
