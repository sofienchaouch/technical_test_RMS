package com.technical.interview.rmsflights.domain.nouvelair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
// A repository that extends JpaRepository.

@Repository
public interface NouvelAirRepository extends JpaRepository<NouvelAirFlight,Long> {
/**
 * // Java
 * 
 * @Query("SELECT f FROM NouvelAirFlight f WHERE f.departureAirportName=:from AND
 * f.arrivalAirportName=:to AND f.outboundDateTime LIKE CONCAT('%',:outboundDate,'%') AND
 * f.inboundDateTime LIKE CONCAT('%',:inboundDate,'%')  ")
 * 
 * @param from The departure airport name
 * @param to The destination airport
 * @param outboundDate "2018-12-01"
 * @param inboundDate the date of the return flight
 * @return A list of NouvelAirFlight objects
 */

    @Query("SELECT f FROM NouvelAirFlight f WHERE f.departureAirportName=:from AND f.arrivalAirportName=:to AND f.outboundDateTime LIKE CONCAT('%',:outboundDate,'%') AND f.inboundDateTime LIKE CONCAT('%',:inboundDate,'%')  ")
    List<NouvelAirFlight> findNouvelAirFlightsByRequest(@Param("from") String from, @Param("to") String to, @Param("outboundDate") String outboundDate, @Param("inboundDate") String inboundDate);
}
