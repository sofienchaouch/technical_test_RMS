package com.technical.interview.rmsflights;

import com.technical.interview.rmsflights.domain.MapStructMapper;
import com.technical.interview.rmsflights.domain.data.IntialisationData;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirFlight;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MapStructMapperTest {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);


    @Test
    public void testTunisAirFlightToTunisAirFlightResponse() {

        TunisAirResponse tunisAirResponse = IntialisationData.initTunisairResponse();
        TunisAirFlight tunisAirFlight = IntialisationData.initTunisairFlight();

        TunisAirResponse result = INSTANCE.tunisAirFlightToTunisAirFlightResponse(tunisAirFlight);

        assertThat(tunisAirResponse).isEqualToComparingFieldByFieldRecursively(result);

    }


    @Test
    public void testTunisAirFlightToAllResponses() {

        List<TunisAirResponse> tunisAirResponses = new ArrayList<>();
        tunisAirResponses.add(IntialisationData.initTunisairResponse());

        List<TunisAirFlight> tunisAirFlights = new ArrayList<>();
        tunisAirFlights.add(IntialisationData.initTunisairFlight());

        List<TunisAirResponse> result = INSTANCE.tunisAirFlightToAllResponses(tunisAirFlights);

        assertThat(tunisAirResponses).usingRecursiveFieldByFieldElementComparator().isEqualTo(result);
    }

    @Test
    public void testNouvelAirFlightToNouvelAirFlightResponse() {

        NouvelAirResponse nouvelAirResponse = IntialisationData.initNouvelAirResponse();
        NouvelAirFlight nouvelAirFlight = IntialisationData.initNouvelAirFlight();

        NouvelAirResponse result = INSTANCE.nouvelAirFlightToNouvelAirFlightResponse(nouvelAirFlight);

        assertThat(nouvelAirResponse).isEqualToComparingFieldByFieldRecursively(result);
    }


    @Test
    public void testNouvelAirFlightToAllResponses() {
        List<NouvelAirResponse> nouvelAirResponses = new ArrayList<>();
        nouvelAirResponses.add(IntialisationData.initNouvelAirResponse());

        List<NouvelAirFlight> nouvelAirFlights = new ArrayList<>();
        nouvelAirFlights.add(IntialisationData.initNouvelAirFlight());

        List<NouvelAirResponse> result = INSTANCE.nouvelAirFlightToAllResponses(nouvelAirFlights);

        assertThat(nouvelAirResponses).usingRecursiveFieldByFieldElementComparator().isEqualTo(result);

    }
}