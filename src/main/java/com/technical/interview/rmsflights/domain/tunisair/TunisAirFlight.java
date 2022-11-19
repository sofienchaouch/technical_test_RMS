package com.technical.interview.rmsflights.domain.tunisair;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
/**
 * A class that represents a flight of TunisAir.
 */

public class TunisAirFlight {

    @Id
    @SequenceGenerator(
            name = "tunisair_flight_sequence",
            sequenceName = "tunisair_flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tunisair_flight_sequence"

    )
    private Long id;
    private String airline;
    private double price;
    private String cabinclass;

    public TunisAirFlight() {
    }

    public TunisAirFlight(String airline, double price, String cabinclass, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.price = price;
        this.cabinclass = cabinclass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    private String departureAirportCode;

    private String destinationAirportCode;

    private String departureDate;
    private String arrivalDate;

}
