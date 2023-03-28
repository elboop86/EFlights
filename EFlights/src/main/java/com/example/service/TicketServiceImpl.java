package com.example.service;

import com.example.entities.Passenger;
import com.example.entities.Ticket;
import com.example.exceptions.InsufficientBalanceException;
import com.example.exceptions.TicketAlreadyPurchasedException;
import com.example.repository.PassengerRepository;
import com.example.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepo;
    private final PassengerRepository passengerService;
    @Override
    public List<Ticket> findAll() { return ticketRepo.findAll(); }

    @Override
    public Optional<Ticket> findById(Long id) { return ticketRepo.findById(id); }

    @Override
    public List<Ticket> findAllByPriceBetween(double min, double max) {
        return ticketRepo.findAllByPriceBetween(min, max); }

    @Override
    public List<Ticket> findAllByPriceLessThanEqual(double price) {
          return ticketRepo.findAllByPriceLessThanEqual(price); }

    @Override
    public List<Ticket> findAllByPassengerId(Long id) {
        return ticketRepo.findAllByPassengerId(id);
    }

    @Override
    public List<Ticket> findAllByFlightId(Long id) {
        return ticketRepo.findAllByFlightId(id);
    }

    @Override
    public Ticket save(Ticket ticket) { return ticketRepo.save(ticket); }

    @Override
    public void deleteById(Long id) { ticketRepo.deleteById(id);

    }

    @Override
    public List<Ticket> saveAll(List<Ticket> tickets) {
        return ticketRepo.saveAll(tickets);

    }

    @Override
    public void buyTicketForCurrentUser(Long ticketId) {
        Passenger passenger = (Passenger) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();

        // Comprobar si el ticket ya tiene pasajero

        if( ticket.getPassenger() != null)
            throw new TicketAlreadyPurchasedException();

        // Comprobar si el passenger no tiene saldo suficiente

        if (ticket.getPrice() > passenger.getBalance())
            throw new InsufficientBalanceException();

        // asociar passenger a ticket y guardar

        ticket.setPassenger(passenger);
        this.save(ticket);

        // restar saldo  passenger

        Double balanceAfterBuy = passenger.getBalance() - ticket.getPrice();
        passenger.setBalance(balanceAfterBuy);
        passengerService.save(passenger);
    }


}
