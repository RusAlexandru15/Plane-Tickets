package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    /**selects all the flights from DB*/
    public List<Flight> getFlights(){
      return flightRepository.findAll();
  }

    /**selects the flight with specified id*/
    public Flight getFlightById(long id){
        return flightRepository.findById(id).orElse(null);
    }

    /**create new flight*/
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }



}
