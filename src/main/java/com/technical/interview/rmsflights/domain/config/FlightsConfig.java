package com.technical.interview.rmsflights.domain.config;

import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirFlight;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirRepository;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to initialize the database with some data
 */

@Configuration
public class FlightsConfig {

    @Bean
    CommandLineRunner commandLineRunner(TunisAirRepository tunisAirRepository, NouvelAirRepository nouvelAirRepository){
        return args -> {

            TunisAirFlight firstFlight =
                    new TunisAirFlight("tunisair",100.21,"E","TUN","FRA",
                            "2022-07-08T11:44:44.797","2022-07-09T11:44:44.797");
            TunisAirFlight secondFlight =
                    new TunisAirFlight("tunisair",90.21,"B","TUN","FRA",
                            "2022-07-08T11:44:44.797","2022-07-09T11:44:44.797");

            List<TunisAirFlight> flights =new ArrayList<>();
            flights.add(firstFlight);
            flights.add(secondFlight);
            tunisAirRepository.save(flights);

            NouvelAirFlight firstFlightNouvelAir =
                    new NouvelAirFlight("nouvelair",200.21,100.32,20.0,"TUN",
                            "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
            NouvelAirFlight secondFlightNouvelAir =
                    new NouvelAirFlight("nouvelair",250.21,110.32,15.0,"TUN",
                            "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");

            List<NouvelAirFlight> flightsNouvelAir =new ArrayList<>();
            flightsNouvelAir.add(firstFlightNouvelAir);
            flightsNouvelAir.add(secondFlightNouvelAir);
            nouvelAirRepository.save(flightsNouvelAir);
        };


    }
}
