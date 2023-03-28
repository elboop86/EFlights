package com.example.controller;

import com.example.service.FileService;
import com.example.service.FlightService;
import com.example.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
@AllArgsConstructor
@Controller
public class TicketController {

    private final TicketService ticketService;
    private final FlightService flightService;
    private final FileService fileService;
}
