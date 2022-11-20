package com.technical.interview.rmsflights.domain.rmsflights;

import com.technical.interview.rmsflights.domain.nouvelair.*;
import com.technical.interview.rmsflights.domain.tunisair.*;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class RmsServiceTest extends TestCase {

    public void testGetRmsFlights() {

        RmsService rmsService = Mockito.mock(RmsService.class);
        TunisAirRepository tunisAirRepository = Mockito.mock(TunisAirRepository.class);

        RmsFlightsRequest rmsFlightsRequest = new RmsFlightsRequest();
        rmsFlightsRequest.setDepartureDate("FRN");
        rmsFlightsRequest.setOrigin("TUN");
        rmsFlightsRequest.setReturnDate("2022-07-09");
        rmsFlightsRequest.setDepartureDate("2022-07-08");
        rmsFlightsRequest.setNumberOfPassengers(1);

        List<TunisAirFlight> tunisAirFlights = new ArrayList<>();
        TunisAirFlight firstFlightTunisAir =
                new TunisAirFlight(1L,"tunisair",200.21,"B","TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
        TunisAirFlight secondFlightTunisAir =
                new TunisAirFlight(2L,"tunisair",250.21,"E","TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");



        tunisAirFlights.add(firstFlightTunisAir);
        tunisAirFlights.add(secondFlightTunisAir);




        given(tunisAirRepository.findTunisAirFlightsByRequest(rmsFlightsRequest.getOrigin(),rmsFlightsRequest.getDestination(),rmsFlightsRequest.getDepartureDate(),rmsFlightsRequest.getReturnDate())).willReturn(tunisAirFlights);

        NouvelAirService nouvelAirService = Mockito.mock(NouvelAirService.class);
        NouvelAirRepository nouvelAirRepository = Mockito.mock(NouvelAirRepository.class);

        NouvelAirRequest nouvelAirRequest = new NouvelAirRequest();
        List<NouvelAirFlight> nouvelAirFlights = new ArrayList<>();
        NouvelAirFlight firstFlightNouvelAir =
                new NouvelAirFlight(1L,"nouvelair",200.21,100.32,20.0,"TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
        NouvelAirFlight secondFlightNouvelAir =
                new NouvelAirFlight(2L,"nouvelair",250.21,110.32,15.0,"TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");



        nouvelAirFlights.add(firstFlightNouvelAir);
        nouvelAirFlights.add(secondFlightNouvelAir);




        given(nouvelAirRepository.findNouvelAirFlightsByRequest(rmsFlightsRequest.getOrigin(),rmsFlightsRequest.getReturnDate(),rmsFlightsRequest.getDepartureDate(),rmsFlightsRequest.getReturnDate())).willReturn(nouvelAirFlights);

        // when -  action or the behaviour that we are going test
        List<NouvelAirResponse> nouvelAirResponseList = nouvelAirService.getNouvelAirFlights(nouvelAirRequest);

        // then - verify the output
        List<RmsFlightsResponse> rmsFlightsResponseList = rmsService.getRmsFlights(rmsFlightsRequest);


        assertThat(rmsFlightsResponseList).isNotNull();

    }
}