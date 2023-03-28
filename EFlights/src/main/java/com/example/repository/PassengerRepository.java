package com.example.repository;

import com.example.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {


    Optional<Passenger> findById(Long Long);

    Optional<Passenger> findByEmail(String email);
}
