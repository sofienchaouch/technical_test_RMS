package com.technical.interview.rmsflights.domain.tunisair;

import com.technical.interview.rmsflights.domain.nouvelair.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class TunisAirServiceTest extends TestCase {



    @Test
    public void testGetTunisAirFlights() {
        TunisAirService tunisAirService = Mockito.mock(TunisAirService.class);
        TunisAirRepository tunisAirRepository = Mockito.mock(TunisAirRepository.class);

        TunisAirRequest tunisAirRequest = new TunisAirRequest();
        List<TunisAirFlight> tunisAirFlights = new ArrayList<>();
        TunisAirFlight firstFlightTunisAir =
                new TunisAirFlight(1L,"tunisair",200.21,"B","TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
        TunisAirFlight secondFlightTunisAir =
                new TunisAirFlight(2L,"tunisair",250.21,"E","TUN",
                        "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");



        tunisAirFlights.add(firstFlightTunisAir);
        tunisAirFlights.add(secondFlightTunisAir);


        tunisAirRequest.setOrigin("TUN");
        tunisAirRequest.setDestination("FRA");
        tunisAirRequest.setReturnDate("2022-07-09");
        tunisAirRequest.setPassengerCount(1);
        tunisAirRequest.setDepartureDate("2022-07-08");


        given(tunisAirRepository.findTunisAirFlightsByRequest(tunisAirRequest.getOrigin(),tunisAirRequest.getDestination(),tunisAirRequest.getDepartureDate(),tunisAirRequest.getReturnDate())).willReturn(tunisAirFlights);

        // when -  action or the behaviour that we are going test
        List<TunisAirResponse> nouvelAirResponseList = tunisAirService.getTunisAirFlights(tunisAirRequest);

        // then - verify the output
        assertThat(nouvelAirResponseList).isNotNull();
    }
}