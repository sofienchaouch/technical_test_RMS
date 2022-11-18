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
public class TunisAirController {

    private final TunisAirService tunisAirService;
    private MapStructMapper mapstructMapper;


    @Autowired
    public TunisAirController(TunisAirService tunisAirService, MapStructMapper mapstructMapper) {
        this.tunisAirService = tunisAirService;
        this.mapstructMapper = mapstructMapper;

    }

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
            return new ResponseEntity<>(mapstructMapper.tunisAirFlightToAllResponses(tunisAirService.getTunisAirFlights(tunisAirRequest)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
