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

    @GetMapping("/flights")
    public List<Flight> getFlightsControlled(){
        return flightService.getFlights();
    }

    @GetMapping("/flights/getFlight{id}")
    public Flight getFlightByIdControlled(@PathVariable Long id){

        return  flightService.getFlightById(id);
    }

    @GetMapping("/flights/getByDay/{day}")
    public List<Flight> getFlightByDayControlled(@PathVariable String day){
        return flightService.getFlightsByDay(day);
    }

    @GetMapping("/flights/getByDeparture/{from}")
    public List<Flight> getFlightByDepartureControlled(@PathVariable String from){
        return flightService.getFlightsByDeparture(from);
    }

    @GetMapping("/flights/getByArrival/{to}")
    public List<Flight> getFlightByArrivalControlled(@PathVariable String to){
        return flightService.getFlightsByArrival(to);
    }


    //POST is used for insert new entity
    @PostMapping("/flights/new")
    public Flight saveFlightControlled(@RequestBody Flight flight){

        return flightService.createFlight(flight);
    }

    @PutMapping("/flights/editFlight{id}")
    public String updateFlightControlled(@PathVariable Long id, @RequestBody Flight flightData){
        return flightService.updateFlightById(id,flightData);
    }

    @DeleteMapping("/flights/deleteFlight{id}")
    public String deleteFlightControlled(@PathVariable Long id){
        return flightService.deleteFlightByID(id);
    }

}
