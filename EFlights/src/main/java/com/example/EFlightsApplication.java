package com.example;


import com.example.entities.Flight;
import com.example.entities.Passenger;
import com.example.repository.FlightRepository;
import com.example.repository.PassengerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

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


		var passengerRepo = context.getBean(PassengerRepository.class);
		var encoder = context.getBean(PasswordEncoder.class);

		Passenger psg1 = new Passenger(null,"psg1@gmail.com", encoder.encode("admin", 400.0, null));
		Passenger psg2 = new Passenger(null,"psg2@gmail.com", encoder.encode("admin", 200.0, null));
		Passenger psg3 = new Passenger(null,"psg3@gmail.com", encoder.encode("admin", 500.0, null));
		Passenger psg4 = new Passenger(null,"psg4@gmail.com", encoder.encode("admin", 350.0, null));
		Passenger psg5 = new Passenger(null,"psg5@gmail.com", encoder.encode("admin", 175.0, null));

		passengerRepo.saveAll(List.of(psg1, psg2, psg3, psg4, psg5));





	}



}
