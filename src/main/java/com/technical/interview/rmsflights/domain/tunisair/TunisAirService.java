package com.technical.interview.rmsflights.domain.tunisair;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * It's a service class that uses a repository to get data from a database.
 */
@Service
public class TunisAirService {

    private final TunisAirRepository tunisAirRepository;

    @Autowired
    public TunisAirService(TunisAirRepository tunisAirRepository) {
        this.tunisAirRepository = tunisAirRepository;
    }

    public List<TunisAirFlight> getTunisAirFlights (TunisAirRequest tunisAirRequest){
        List<TunisAirFlight> tunisAirFlights =  tunisAirRepository.findTunisAirFlightsByRequest(tunisAirRequest.getOrigin(),tunisAirRequest.getDestination(),tunisAirRequest.getDepartureDate(),tunisAirRequest.getReturnDate());

        for (TunisAirFlight tunisAirFlight: tunisAirFlights) {
            tunisAirFlight.setPrice(tunisAirFlight.getPrice()*tunisAirRequest.getPassengerCount());
        }
        return tunisAirFlights;
    }

}
