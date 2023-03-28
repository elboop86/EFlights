package com.example.service;

import com.example.entities.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> findAll();

    Passenger save(Passenger passenger);
}
