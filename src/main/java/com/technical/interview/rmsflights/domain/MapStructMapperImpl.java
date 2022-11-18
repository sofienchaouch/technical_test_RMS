package com.technical.interview.rmsflights.domain;

import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirFlight;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapStructMapperImpl implements MapStructMapper{
    @Override
    public TunisAirResponse tunisAirFlightToTunisAirFlightResponse(TunisAirFlight tunisAirFlight) {
        if ( tunisAirFlight == null ) {
            return null;
        }

        TunisAirResponse tunisAirResponse = new TunisAirResponse();

        tunisAirResponse.setAirline( tunisAirFlight.getAirline() );
        tunisAirResponse.setPrice( tunisAirFlight.getPrice() );
        tunisAirResponse.setCabinclass( tunisAirFlight.getCabinclass() );
        tunisAirResponse.setDepartureAirportCode( tunisAirFlight.getDepartureAirportCode() );
        tunisAirResponse.setDestinationAirportCode( tunisAirFlight.getDestinationAirportCode() );
        tunisAirResponse.setDepartureDate( tunisAirFlight.getDepartureDate() );
        tunisAirResponse.setArrivalDate( tunisAirFlight.getArrivalDate() );

        return tunisAirResponse;    }

    @Override
    public List<TunisAirResponse> tunisAirFlightToAllResponses(List<TunisAirFlight> tunisAirFlights) {
        if ( tunisAirFlights == null ) {
            return null;
        }

        List<TunisAirResponse> list = new ArrayList<TunisAirResponse>( tunisAirFlights.size() );
        for ( TunisAirFlight tunisAirFlight : tunisAirFlights ) {
            list.add( tunisAirFlightToTunisAirFlightResponse( tunisAirFlight ) );
        }

        return list;    }

    @Override
    public NouvelAirResponse nouvelAirFlightToNouvelAirFlightResponse(NouvelAirFlight nouvelAirFlight) {
        if ( nouvelAirFlight == null ) {
            return null;
        }

        NouvelAirResponse nouvelAirResponse = new NouvelAirResponse();

        nouvelAirResponse.setCarrier( nouvelAirFlight.getCarrier() );
        nouvelAirResponse.setBasePrice( nouvelAirFlight.getBasePrice() );
        nouvelAirResponse.setDiscount( nouvelAirFlight.getDiscount() );
        nouvelAirResponse.setTax( nouvelAirFlight.getTax() );
        nouvelAirResponse.setArrivalAirportName( nouvelAirFlight.getArrivalAirportName() );
        nouvelAirResponse.setDepartureAirportName( nouvelAirFlight.getDepartureAirportName() );
        nouvelAirResponse.setInboundDateTime( nouvelAirFlight.getInboundDateTime() );
        nouvelAirResponse.setOutboundDateTime( nouvelAirFlight.getOutboundDateTime() );

        return nouvelAirResponse;      }

    @Override
    public List<NouvelAirResponse> nouvelAirFlightToAllResponses(List<NouvelAirFlight> nouvelAirFlights) {
        if ( nouvelAirFlights == null ) {
            return null;
        }

        List<NouvelAirResponse> list = new ArrayList<NouvelAirResponse>( nouvelAirFlights.size() );
        for ( NouvelAirFlight nouvelAirFlight : nouvelAirFlights ) {
            list.add( nouvelAirFlightToNouvelAirFlightResponse( nouvelAirFlight ) );
        }

        return list;      }
}
