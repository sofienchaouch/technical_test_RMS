package com.technical.interview.rmsflights.domain.rmsflights;


import com.technical.interview.rmsflights.domain.MapStructMapper;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirRequest;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * This class is a controller class that handles the request and response of the RMS API
 */

@RestController
@RequestMapping(path = "rmsflights")
public class RmsController {

    private final RmsService rmsService;


    @Autowired
    public RmsController(RmsService rmsService) {
        this.rmsService = rmsService;

    }

    @GetMapping
    @RequestMapping(path = "flights")
    @ResponseBody
    public ResponseEntity<List<RmsFlightsResponse>> getNouvelAirFlights (@RequestParam("origin") @Pattern(regexp = "^[A-Z]{3}", message = "Invalid IATA code")
                                                                        String origin,
                                                                        @RequestParam("destination") @Pattern(regexp = "^[A-Z]{3}", message = "Invalid IATA code")
                                                                        String destination,
                                                                        @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate,
                                                                        @RequestParam("returnDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date returnDate,
                                                                        @RequestParam("numberOfPassengers")  @Max(4) int numberOfPassengers){

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String departureDateFormat = formatter.format(departureDate);
            String returnDateFormat = formatter.format(returnDate);

            RmsFlightsRequest rmsFlightsRequest = new RmsFlightsRequest(origin,destination,departureDateFormat,returnDateFormat,numberOfPassengers);
            return new ResponseEntity<>(rmsService.getRmsFlights(rmsFlightsRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
