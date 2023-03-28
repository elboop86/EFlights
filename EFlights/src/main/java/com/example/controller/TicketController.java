package com.example.controller;

import com.example.entities.Passenger;
import com.example.entities.Ticket;
import com.example.service.FileService;
import com.example.service.FlightService;
import com.example.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class TicketController {

    private final TicketService ticketService;
    private final FlightService flightService;
    private final FileService fileService;

    // recuperar los tickets sin filtrar

    @GetMapping("tickets")
    public String findAll(Model model) {
        model.addAttribute("tickets", ticketService.findAll());

        return  "ticket/ticket-list";
    }
    // recupera los tickets del usuario con la sesión iniciada
    @GetMapping("user-tickets")
    public String findAllByCurrentUser(Model model) {
        Passenger currentUser = (Passenger) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        model.addAttribute("tickets", ticketService.findAllByPassengerId(currentUser.getId()));

        return  "ticket/ticket-list";
    }

    @GetMapping("tickets/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Ticket> ticketOptional =ticketService.findById(id);
        if (ticketOptional.isPresent())
            model.addAttribute("tickets", ticketService.findAll());
        else
            model.addAttribute("error","No encontrado");


        return  "ticket/ticket-list";
    }
}
