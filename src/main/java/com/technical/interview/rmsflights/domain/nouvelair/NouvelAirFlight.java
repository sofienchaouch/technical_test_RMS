package com.technical.interview.rmsflights.domain.nouvelair;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
/**
 * NouvelAirFlight is a class that represents a flight from one airport to another
 */

@Entity
@Table
@Data
@AllArgsConstructor
public class NouvelAirFlight {

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
    private String carrier;
    private double basePrice;

    public NouvelAirFlight() {
    }

    public NouvelAirFlight(String carrier, double basePrice, double tax, double discount, String departureAirportName, String arrivalAirportName, String outboundDateTime, String inboundDateTime) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.outboundDateTime = outboundDateTime;
        this.inboundDateTime = inboundDateTime;
    }

    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private String outboundDateTime;
    private String inboundDateTime;

}
