package com.example.demo.repository;

import com.example.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {


    /**Querry pentru gasire zborurilor in functie de zi :format dd-mm-yyyy */
    @Query("SELECT e FROM Flight e WHERE e.ziua = :ziua")
    List<Flight> findByDate(@Param("ziua") String ziua);

    /**Querry pentru gasire zborurilor in functie de plecare */
    @Query("SELECT e FROM Flight e WHERE e.from = :from")
    List<Flight> findByDeparture(@Param("from") String from);

    /**Querry pentru gasire zborurilor in functie de sosire */
    @Query("SELECT e FROM Flight e WHERE e.to = :to")
    List<Flight> findByArrival(@Param("to") String to);


}
