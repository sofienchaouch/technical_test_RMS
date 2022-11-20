package com.technical.interview.rmsflights.domain.nouvelair;

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
        NouvelAirRequest nouvelAirRequest = new NouvelAirRequest();

        nouvelAirRequest.setFrom("TEN");
        nouvelAirRequest.setTo("FRA");
        nouvelAirRequest.setInboundDate("2022-07-09");
        nouvelAirRequest.setNumberOfAdults(1);
        nouvelAirRequest.setOutboundDate("2022-07-08");

        Mockito.when(nouvelAirRepository
                        .findNouvelAirFlightsByRequest(nouvelAirRequest.getFrom(),nouvelAirRequest.getTo(),nouvelAirRequest.getOutboundDate(),nouvelAirRequest.getInboundDate()))
                .thenReturn(nouvelAirFlights).thenReturn(nouvelAirFlights);
        List<NouvelAirResponse> result = nouvelAirService.getNouvelAirFlights(nouvelAirRequest);


        assertEquals(result,nouvelAirFlights);
    }
}