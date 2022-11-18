package com.technical.interview.rmsflights.domain.tunisair;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TunisAirService {

    private final TunisAirRepository tunisAirRepository;

    @Autowired
    public TunisAirService(TunisAirRepository tunisAirRepository) {
        this.tunisAirRepository = tunisAirRepository;
    }

    public List<TunisAirFlight> getTunisAirFlights (TunisAirRequest tunisAirRequest){

        return tunisAirRepository.findTunisAirFlightsByRequest(tunisAirRequest.getOrigin(),tunisAirRequest.getDestination(),tunisAirRequest.getDepartureDate(),tunisAirRequest.getReturnDate());
    }

}
