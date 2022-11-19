package com.technical.interview.rmsflights.domain.nouvelair;


import com.technical.interview.rmsflights.domain.MapStructMapper;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRequest;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * This class is a controller class that is responsible for handling the incoming requests and
 * returning the appropriate response
 */

@RestController
@RequestMapping(path = "nouvelair")
public class NouvelAirController {

    private final NouvelAirService nouvelAirService;
    private MapStructMapper mapstructMapper;


    @Autowired
    public NouvelAirController(NouvelAirService nouvelAirService, MapStructMapper mapstructMapper) {
        this.nouvelAirService = nouvelAirService;
        this.mapstructMapper = mapstructMapper;

    }

    @GetMapping
    @RequestMapping(path = "flights")
    @ResponseBody
    public ResponseEntity<List<NouvelAirResponse>> getNouvelAirFlights (@RequestParam("from") @Pattern(regexp = "^[A-Z]{3}", message = "Invalid IATA code")
                                                                  String from,
                                                                      @RequestParam("to") @Pattern(regexp = "^[A-Z]{3}", message = "Invalid IATA code")
                                                                  String to,
                                                                      @RequestParam("outboundDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date outboundDate,
                                                                      @RequestParam("inboundDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inboundDate,
                                                                      @RequestParam("numberOfAdults") int numberOfAdults){

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String outboundDateFortmat = formatter.format(outboundDate);
            String inboundDateFormat = formatter.format(inboundDate);

            NouvelAirRequest nouvelAirRequest = new NouvelAirRequest(from,to,outboundDateFortmat,inboundDateFormat,numberOfAdults);
            return new ResponseEntity<>(mapstructMapper.nouvelAirFlightToAllResponses(nouvelAirService.getNouvelAirFlights(nouvelAirRequest)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
