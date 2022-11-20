package com.technical.interview.rmsflights.domain.tunisair;


import com.technical.interview.rmsflights.domain.MapStructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * It's a service class that uses a repository to get data from a database.
 */
@Service
public class TunisAirService {

    private final TunisAirRepository tunisAirRepository;
    private MapStructMapper mapstructMapper;

    @Autowired
    public TunisAirService(TunisAirRepository tunisAirRepository, MapStructMapper mapstructMapper) {
        this.tunisAirRepository = tunisAirRepository;
        this.mapstructMapper = mapstructMapper;

    }

    public List<TunisAirResponse> getTunisAirFlights (TunisAirRequest tunisAirRequest){
        List<TunisAirFlight> tunisAirFlights =  tunisAirRepository.findTunisAirFlightsByRequest(tunisAirRequest.getOrigin(),tunisAirRequest.getDestination(),tunisAirRequest.getDepartureDate(),tunisAirRequest.getReturnDate());

        for (TunisAirFlight tunisAirFlight: tunisAirFlights) {
            tunisAirFlight.setPrice(tunisAirFlight.getPrice()*tunisAirRequest.getPassengerCount());
        }
        return  mapstructMapper.tunisAirFlightToAllResponses(tunisAirFlights);
    }

}
