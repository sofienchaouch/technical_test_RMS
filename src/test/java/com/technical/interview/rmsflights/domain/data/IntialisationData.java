package com.technical.interview.rmsflights.domain.data;

import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirFlight;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirFlight;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;

public class IntialisationData {

    public static TunisAirFlight initTunisairFlight() {

        TunisAirFlight tunisAirFlight = new TunisAirFlight();
        tunisAirFlight.setAirline("tunisair");
        tunisAirFlight.setPrice(100.21);
        tunisAirFlight.setCabinclass("E");
        tunisAirFlight.setDepartureAirportCode("TUN");
        tunisAirFlight.setDestinationAirportCode("FRA");
        tunisAirFlight.setDepartureDate("2022-07-08T11:44:44.797");
        tunisAirFlight.setArrivalDate("2022-07-09T11:44:44.797");
        tunisAirFlight.setId(20L);

        return tunisAirFlight;
    }

    public static TunisAirResponse initTunisairResponse() {

        TunisAirResponse tunisAirResponse = new TunisAirResponse();
        tunisAirResponse.setAirline("tunisair");
        tunisAirResponse.setPrice(100.21);
        tunisAirResponse.setCabinclass("E");
        tunisAirResponse.setDepartureAirportCode("TUN");
        tunisAirResponse.setDestinationAirportCode("FRA");
        tunisAirResponse.setDepartureDate("2022-07-08T11:44:44.797");
        tunisAirResponse.setArrivalDate("2022-07-09T11:44:44.797");

        return tunisAirResponse;

    }

    public static NouvelAirFlight initNouvelAirFlight() {

        NouvelAirFlight nouvelAirFlight = new NouvelAirFlight();
        nouvelAirFlight.setCarrier("tunisair");
        nouvelAirFlight.setBasePrice(100.21);
        nouvelAirFlight.setDiscount(10);
        nouvelAirFlight.setTax(10);
        nouvelAirFlight.setDepartureAirportName("TUN");
        nouvelAirFlight.setArrivalAirportName("FRA");
        nouvelAirFlight.setOutboundDateTime("2022-07-08T11:44:44.797");
        nouvelAirFlight.setInboundDateTime("2022-07-09T11:44:44.797");
        nouvelAirFlight.setId(20L);

        return nouvelAirFlight;
    }

    public static NouvelAirResponse initNouvelAirResponse() {

        NouvelAirResponse nouvelAirResponse = new NouvelAirResponse();
        nouvelAirResponse.setCarrier("tunisair");
        nouvelAirResponse.setBasePrice(100.21);
        nouvelAirResponse.setTax(10);
        nouvelAirResponse.setDepartureAirportName("TUN");
        nouvelAirResponse.setArrivalAirportName("FRA");
        nouvelAirResponse.setOutboundDateTime("2022-07-08T11:44:44.797");
        nouvelAirResponse.setInboundDateTime("2022-07-09T11:44:44.797");
        nouvelAirResponse.setDiscount(10);

        return nouvelAirResponse;

    }
}