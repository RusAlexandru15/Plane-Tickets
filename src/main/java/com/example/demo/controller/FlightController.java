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

    /** returns all flights from the database */
    @GetMapping("/flights")
    public List<Flight> getFlightsControlled(){
        return flightService.getFlights();
    }

    /** returns a flight according to  its id */
    @GetMapping("/flights/getFlight{id}")
    public Flight getFlightByIdControlled(@PathVariable Long id){

        return  flightService.getFlightById(id);
    }

    /** returns a flight depending on the day of departure */
    @GetMapping("/flights/getByDay/{day}")
    public List<Flight> getFlightByDayControlled(@PathVariable String day){
        return flightService.getFlightsByDay(day);
    }

    /** returns a flight depending on  departure */
    @GetMapping("/flights/getByDeparture/{from}")
    public List<Flight> getFlightByDepartureControlled(@PathVariable String from){
        return flightService.getFlightsByDeparture(from);
    }

    /** returns a flight depending on  arrival */
    @GetMapping("/flights/getByArrival/{to}")
    public List<Flight> getFlightByArrivalControlled(@PathVariable String to){
        return flightService.getFlightsByArrival(to);
    }


    /** creates a new flight with information received from a requestBody */
    @PostMapping("/flights/new")
    public Flight saveFlightControlled(@RequestBody Flight flight){

        return flightService.createFlight(flight);
    }

    /** modifies the flight with the given id having information received from a requestBody */
    @PutMapping("/flights/editFlight{id}")
    public String updateFlightControlled(@PathVariable Long id, @RequestBody Flight flightData){
        return flightService.updateFlightById(id,flightData);
    }

    /** deletes the flight with the given id */
    @DeleteMapping("/flights/deleteFlight{id}")
    public String deleteFlightControlled(@PathVariable Long id){
        return flightService.deleteFlightByID(id);
    }

}
