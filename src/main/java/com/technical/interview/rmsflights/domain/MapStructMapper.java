package com.technical.interview.rmsflights.domain;


import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirFlight;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    TunisAirResponse tunisAirFlightToTunisAirFlightResponse(TunisAirFlight tunisAirFlight);

    List<TunisAirResponse> tunisAirFlightToAllResponses(List<TunisAirFlight> tunisAirFlights);

    NouvelAirResponse nouvelAirFlightToNouvelAirFlightResponse(NouvelAirFlight nouvelAirFlight);

    List<NouvelAirResponse> nouvelAirFlightToAllResponses(List<NouvelAirFlight> nouvelAirFlights);


}
