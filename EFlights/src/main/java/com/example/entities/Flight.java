package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plane;
    private String airportFrom;
    private String airportTo;
    private LocalDateTime dateTimeFrom; // salida
    private LocalDateTime dateTimeTo;  // llegada
    private Integer seats;  // asientos

   // @OneToMany(mappedBy = "flight")
   // @ToString.Exclude
   // Set<Tiket> tickets = new HashSet<>();


    public Flight(Long id) {this.id = id;}
}
