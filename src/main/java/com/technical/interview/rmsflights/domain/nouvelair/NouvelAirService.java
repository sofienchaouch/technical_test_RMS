package com.technical.interview.rmsflights.domain.nouvelair;


import com.technical.interview.rmsflights.domain.MapStructMapper;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is a service class that is used to get the data from the database using the repository
 * class
 */
@Service
public class NouvelAirService {

    private final NouvelAirRepository  NouvelAirRepository;
    private MapStructMapper mapstructMapper;

    @Autowired
    public NouvelAirService (NouvelAirRepository NouvelAirRepository,MapStructMapper mapstructMapper) {
        this.NouvelAirRepository = NouvelAirRepository;
        this.mapstructMapper = mapstructMapper;

    }

    public List<NouvelAirResponse > getNouvelAirFlights (NouvelAirRequest nouvelAirRequest){

        List<NouvelAirFlight > nouvelAirFlights=  NouvelAirRepository.findNouvelAirFlightsByRequest(nouvelAirRequest.getFrom(),nouvelAirRequest.getTo(),nouvelAirRequest.getOutboundDate(),nouvelAirRequest.getInboundDate());


        for (NouvelAirFlight nouvelAirFlight: nouvelAirFlights) {
            nouvelAirFlight.setBasePrice(nouvelAirFlight.getBasePrice()*nouvelAirRequest.getNumberOfAdults());
        }

        return mapstructMapper.nouvelAirFlightToAllResponses(nouvelAirFlights);

    }

    public List<NouvelAirFlight > findAll (){

        return NouvelAirRepository.findAll();
    }

}
