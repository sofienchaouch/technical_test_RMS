package com.technical.interview.rmsflights.domain.nouvelair;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class NouvelAirConfig {

    @Bean
    CommandLineRunner commandLineRunner(NouvelAirRepository nouvelAirRepository){
        return args -> {

            NouvelAirFlight firstFlight =
                    new NouvelAirFlight("nouvelair",200.21,100.32,20.0,"TUN",
                            "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");
            NouvelAirFlight secondFlight =
                    new NouvelAirFlight("nouvelair",250.21,110.32,15.0,"TUN",
                            "FRA","2022-07-08T09:28:27.141Z","2022-07-09T09:28:27.141Z");

            List<NouvelAirFlight> flights =new ArrayList<>();
            flights.add(firstFlight);
            flights.add(secondFlight);
            nouvelAirRepository.save(flights);
        };


    }
}
