package com.technical.interview.rmsflights.domain.rmsflights;

import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirFlight;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirRepository;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRepository;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service

/**
 * A service class that provides access to the RMS.
 */
public class RmsService {

    private final TunisAirRepository tunisAirRepository;
    private final NouvelAirRepository nouvelAirRepository;

    @Autowired
    public RmsService(TunisAirRepository tunisAirRepository,NouvelAirRepository nouvelAirRepository) {
        this.tunisAirRepository = tunisAirRepository;
        this.nouvelAirRepository = nouvelAirRepository;

    }

    public List<RmsFlightsResponse> getRmsFlights (RmsFlightsRequest rmsFlightsRequest){

        List<RmsFlightsResponse> rmsFlightsResponseList = new ArrayList<>();
        List<TunisAirFlight>  tunisAirFlights =  tunisAirRepository.findTunisAirFlightsByRequest(rmsFlightsRequest.getOrigin(),rmsFlightsRequest.getDestination(),rmsFlightsRequest.getDepartureDate(),rmsFlightsRequest.getReturnDate());
        List<NouvelAirFlight>  nouvelAirFlights =  nouvelAirRepository.findNouvelAirFlightsByRequest(rmsFlightsRequest.getOrigin(),rmsFlightsRequest.getDestination(),rmsFlightsRequest.getDepartureDate(),rmsFlightsRequest.getReturnDate());

        for (TunisAirFlight tunisAirFlight: tunisAirFlights) {
            RmsFlightsResponse rmsFlightsResponse = new RmsFlightsResponse();

            rmsFlightsResponse.setAirline(tunisAirFlight.getAirline());
            rmsFlightsResponse.setArrivalDate(tunisAirFlight.getArrivalDate());
            rmsFlightsResponse.setDepartureDate(tunisAirFlight.getDepartureDate());
            rmsFlightsResponse.setDestinationAirportCode(tunisAirFlight.getDestinationAirportCode());
            rmsFlightsResponse.setDepartureAirportCode(tunisAirFlight.getDepartureAirportCode());
            rmsFlightsResponse.setFare(tunisAirFlight.getPrice());

            rmsFlightsResponseList.add(rmsFlightsResponse);

        }

        for (NouvelAirFlight nouvelAirFlight: nouvelAirFlights) {
            RmsFlightsResponse rmsFlightsResponse = new RmsFlightsResponse();

            rmsFlightsResponse.setAirline(nouvelAirFlight.getCarrier());
            rmsFlightsResponse.setArrivalDate(nouvelAirFlight.getInboundDateTime());
            rmsFlightsResponse.setDepartureDate(nouvelAirFlight.getOutboundDateTime());
            rmsFlightsResponse.setDestinationAirportCode(nouvelAirFlight.getArrivalAirportName());
            rmsFlightsResponse.setDepartureAirportCode(nouvelAirFlight.getDepartureAirportName());
            rmsFlightsResponse.setFare( (Math.round(((rmsFlightsRequest.getNumberOfPassengers() *nouvelAirFlight.getBasePrice() * nouvelAirFlight.getDiscount() / 100.0 ) + nouvelAirFlight.getTax() )* 100.0) / 100.0));

            rmsFlightsResponseList.add(rmsFlightsResponse);

        }

        rmsFlightsResponseList.sort(Comparator.comparing(a -> a.getFare()));


        return rmsFlightsResponseList;
    }
}
