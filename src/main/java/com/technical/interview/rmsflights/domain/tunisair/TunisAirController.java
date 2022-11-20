package com.technical.interview.rmsflights.domain.tunisair;


import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.technical.interview.rmsflights.domain.MapStructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "tunisair")
/**
 * A controller class for the TunisAir application.
 */
public class TunisAirController {

    private final TunisAirService tunisAirService;


    @Autowired
    public TunisAirController(TunisAirService tunisAirService) {
        this.tunisAirService = tunisAirService;

    }

    @GetMapping
    @RequestMapping(path = "hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    /**
 * I'm trying to map a list of TunisAirResponse to a list of AllResponses
 * 
 * @param origin The IATA code of the origin airport.
 * @param destination The destination IATA code.
 * @param departureDate 2019-12-12
 * @param returnDate 2019-12-31
 * @param passengerCount the number of passengers
 * @return A list of TunisAirResponse objects.
 */


    @GetMapping
    @RequestMapping(path = "flights")
    @ResponseBody
    public ResponseEntity<List<TunisAirResponse>> getTunisAirFlights (        @RequestParam("origin") @Pattern(regexp = "^[A-Z]{3}", message = "Invalid IATA code")
                                                                  String origin,
                                                              @RequestParam("destination") @Pattern(regexp = "^[A-Z]{3}", message = "Invalid IATA code")
                                                                  String destination,
                                                              @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate,
                                                              @RequestParam("returnDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date returnDate,
                                                              @RequestParam("passengerCount") int passengerCount){

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String departureDateformat = formatter.format(departureDate);
            String returnDateformat = formatter.format(returnDate);

            TunisAirRequest tunisAirRequest = new TunisAirRequest(origin, destination, departureDateformat, returnDateformat,
                    passengerCount);
            return new ResponseEntity<>(tunisAirService.getTunisAirFlights(tunisAirRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
