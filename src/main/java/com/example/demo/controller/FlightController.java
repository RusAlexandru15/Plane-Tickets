package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("/")
    public List<Flight> getFlightsControlled(){
        return flightService.getFlights();
    }

    @GetMapping("/flight{id}")
    public Flight getFlightByIdControlled(@PathVariable Long id){
        return  flightService.getFlightById(id);
    }

    /**POST is used for insert new entity*/
    @PostMapping("/new")
    public Flight saveFlightControlled(@RequestBody Flight flight){
        return flightService.createFlight(flight);
    }

}
