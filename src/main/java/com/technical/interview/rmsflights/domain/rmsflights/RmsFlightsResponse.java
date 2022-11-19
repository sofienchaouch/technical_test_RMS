package com.technical.interview.rmsflights.domain.rmsflights;

import lombok.Data;
/**
 * This class represents a single flight
 */

@Data
public class RmsFlightsResponse {
    private String airline ;
    private Double fare ;
    private String departureAirportCode ;
    private String destinationAirportCode ;
    private String departureDate ;
    private String arrivalDate ;

    public RmsFlightsResponse() {
    }

    public RmsFlightsResponse(String airline, Double fare, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

}
