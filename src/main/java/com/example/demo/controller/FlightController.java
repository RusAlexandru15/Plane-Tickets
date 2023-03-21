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
    public List<Flight> getAllFlights(){
        return flightService.getFlights();
    }




}
