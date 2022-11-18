package com.technical.interview.rmsflights.domain.tunisair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TunisAirRepository extends JpaRepository<TunisAirFlight,Long> {

    @Query("SELECT f FROM TunisAirFlight f WHERE f.departureAirportCode=:departureAirportCode AND f.destinationAirportCode=:destinationAirportCode AND f.departureDate LIKE CONCAT('%',:departureDate,'%') AND f.arrivalDate LIKE CONCAT('%',:arrivalDate,'%')  ")
    List<TunisAirFlight> findTunisAirFlightsByRequest(@Param("departureAirportCode") String departureAirportCode,@Param("destinationAirportCode") String destinationAirportCode,@Param("departureDate") String departureDate,@Param("arrivalDate") String arrivalDate);
}
