package com.example.controller;

import com.example.entities.Flight;
import com.example.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@Controller

public class FlightController {

    private final FlightService flightService;
    @GetMapping("flights")  // URL
    public String findAll(Model model) {
        model.addAttribute("mensaje1", "Primer mensaje Hola");
        model.addAttribute("mensaje2", "Segundo mensaje Que tal");
        model.addAttribute("flights", flightService.findAll()); // HTML

        return "flight/flight-list"; // vista
    }

    // Detalle de un vuelo concreto por su id
    @GetMapping("flights/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Flight> flightOptional =flightService.findById(id);
        if (flightOptional.isPresent())
            model.addAttribute("flight", flightOptional.get());
        else
            model.addAttribute("error", "No encontrado");

        return "flight/flight-detail"; // vista

    }

    // Mostrar formulario para crear/editar un vuelo
    @GetMapping("flights/create")
    public String showCreateFrom(@ModelAttribute Flight flight) {
        model.addAttribute("flight", new Flight());

        return "flights/flight-from";
    }
    // Guardar formulario para crear/editar un vuelo
    @GetMapping("flights")
    public String saveForm(@ModelAttribute Flight flight) {
        flightService.save(flight);

        return "redirect:/flights";
    }

    // Mostrar formulario para editar

    @GetMapping("flights/{id}/edit")
    public String showEditFrom(Model model, @PathVariable Long id) {
        Optional<Flight> flightOptional= flightService.findById(id);
        if (flightOptional.isPresent())
            model.addAttribute("flight", flightOptional.get());
        else
            model.addAttribute("error", "No encontrado");

        return "flight/flight-from";
    }

    // Borrar vuelo

    @GetMapping("flights/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        flightService.deleteById(id);
        return "redirect:/flights";
    }

}
