package com.technical.interview.rmsflights.domain.nouvelair;

import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class NouvelAirServiceTest extends TestCase {

    @Test
    public void testGetNouvelAirFlights() {
        NouvelAirService nouvelAirService = Mockito.mock(NouvelAirService.class);
        NouvelAirRepository nouvelAirRepository = Mockito.mock(NouvelAirRepository.class);

        List<NouvelAirFlight > nouvelAirFlights = new ArrayList<>();
        NouvelAirFlight firstFlightNouvelAir =
                new NouvelAirFlight("nouvelair",200.21,100.32,20.0,"TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
        NouvelAirFlight secondFlightNouvelAir =
                new NouvelAirFlight("nouvelair",250.21,110.32,15.0,"TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");



        nouvelAirFlights.add(firstFlightNouvelAir);
        nouvelAirFlights.add(secondFlightNouvelAir);

        NouvelAirRequest nouvelAirRequest = new NouvelAirRequest();

        nouvelAirRequest.setFrom("TEN");
        nouvelAirRequest.setTo("FRA");
        nouvelAirRequest.setInboundDate("2022-07-09");
        nouvelAirRequest.setNumberOfAdults(1);
        nouvelAirRequest.setOutboundDate("2022-07-08");

        Mockito.when(nouvelAirRepository
                        .findNouvelAirFlightsByRequest(nouvelAirRequest.getFrom(),nouvelAirRequest.getTo(),nouvelAirRequest.getOutboundDate(),nouvelAirRequest.getInboundDate()))
                .thenReturn(nouvelAirFlights).thenReturn(nouvelAirFlights);
        List<NouvelAirFlight> result = nouvelAirRepository.findNouvelAirFlightsByRequest(nouvelAirRequest.getFrom(),nouvelAirRequest.getTo(),nouvelAirRequest.getOutboundDate(),nouvelAirRequest.getInboundDate());


        assertEquals(nouvelAirFlights,result);
    }
}