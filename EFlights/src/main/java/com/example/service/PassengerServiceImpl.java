package com.example.service;

import com.example.entities.Passenger;
import com.example.repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PassengerServiceImpl implements PassengerService, UserDetailsService {

    private final PassengerRepository passengerRepo;

    @Override
    public List<Passenger> findAll() { return passengerRepo.findAll(); }

    @Override
    public Passenger save(Passenger passenger) { return passengerRepo.save(passenger); }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return passengerRepo.findByEmail(username).orElseThrow( () -> new UsernameNotFoundException("no encontrado"));
    }
}
