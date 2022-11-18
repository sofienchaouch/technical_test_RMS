package com.technical.interview.rmsflights.domain.nouvelair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NouvelAirRepository extends JpaRepository<NouvelAirFlight,Long> {

    @Query("SELECT f FROM NouvelAirFlight f WHERE f.departureAirportName=:from AND f.arrivalAirportName=:to AND f.outboundDateTime LIKE CONCAT('%',:outboundDate,'%') AND f.inboundDateTime LIKE CONCAT('%',:inboundDate,'%')  ")
    List<NouvelAirFlight> findNouvelAirFlightsByRequest(@Param("from") String from, @Param("to") String to, @Param("outboundDate") String outboundDate, @Param("inboundDate") String inboundDate);
}
