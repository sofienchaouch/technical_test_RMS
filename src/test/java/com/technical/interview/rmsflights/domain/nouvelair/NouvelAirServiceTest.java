package com.technical.interview.rmsflights.domain.nouvelair;

import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class NouvelAirServiceTest extends TestCase {




    @Test
    public void testGetNouvelAirFlights() {
        NouvelAirService nouvelAirService = Mockito.mock(NouvelAirService.class);
        NouvelAirRepository nouvelAirRepository = Mockito.mock(NouvelAirRepository.class);

         NouvelAirRequest nouvelAirRequest = new NouvelAirRequest();
        List<NouvelAirFlight > nouvelAirFlights = new ArrayList<>();
        NouvelAirFlight firstFlightNouvelAir =
                new NouvelAirFlight(1L,"nouvelair",200.21,100.32,20.0,"TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
        NouvelAirFlight secondFlightNouvelAir =
                new NouvelAirFlight(2L,"nouvelair",250.21,110.32,15.0,"TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");



        nouvelAirFlights.add(firstFlightNouvelAir);
        nouvelAirFlights.add(secondFlightNouvelAir);


        nouvelAirRequest.setFrom("TUN");
        nouvelAirRequest.setTo("FRA");
        nouvelAirRequest.setInboundDate("2022-07-09");
        nouvelAirRequest.setNumberOfAdults(1);
        nouvelAirRequest.setOutboundDate("2022-07-08");


        given(nouvelAirRepository.findNouvelAirFlightsByRequest(nouvelAirRequest.getFrom(),nouvelAirRequest.getTo(),nouvelAirRequest.getOutboundDate(),nouvelAirRequest.getInboundDate())).willReturn(nouvelAirFlights);

        // when -  action or the behaviour that we are going test
        List<NouvelAirResponse> nouvelAirResponseList = nouvelAirService.getNouvelAirFlights(nouvelAirRequest);

        // then - verify the output
        assertThat(nouvelAirResponseList).isNotNull();
    }
}