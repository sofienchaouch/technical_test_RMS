package com.technical.interview.rmsflights.domain.nouvelair;


import com.technical.interview.rmsflights.domain.tunisair.TunisAirRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NouvelAirService {

    private final NouvelAirRepository  NouvelAirRepository;

    @Autowired
    public NouvelAirService (NouvelAirRepository NouvelAirRepository) {
        this.NouvelAirRepository = NouvelAirRepository;
    }

    public List<NouvelAirFlight > getNouvelAirFlights (NouvelAirRequest nouvelAirRequest){

        return NouvelAirRepository.findNouvelAirFlightsByRequest(nouvelAirRequest.getFrom(),nouvelAirRequest.getTo(),nouvelAirRequest.getOutboundDate(),nouvelAirRequest.getInboundDate());
    }

}
