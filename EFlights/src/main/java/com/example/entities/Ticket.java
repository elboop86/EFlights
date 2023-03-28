package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seat;
    private Double price;
    private Boolean food;
    private String imageUrl;

    @ManyToOne
    @ToString.Exclude
    private Flight flight;

    @ManyToOne
    @ToString.Exclude
    private Passenger passenger;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(getId(), ticket.getId()) && Objects.equals(getSeat(), ticket.getSeat()) && Objects.equals(getPrice(),
                ticket.getPrice()) && Objects.equals(getFood(), ticket.getFood()) && Objects.equals(getImageUrl(),
                ticket.getImageUrl()) && Objects.equals(getFlight(), ticket.getFlight()) && Objects.equals(getPassenger(), ticket.getPassenger());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSeat(), getPrice(), getFood(), getImageUrl(), getFlight(), getPassenger());
    }
}