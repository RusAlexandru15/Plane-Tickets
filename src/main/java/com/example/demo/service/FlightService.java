package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import org.jetbrains.annotations.NotNull;
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

    /**selects all flights by day*/
    public List<Flight> getFlightsByDay(String day){
        return flightRepository.findByDate(day);
    }

    /**selects all flights by departure*/
    public List<Flight> getFlightsByDeparture(String from){
        return flightRepository.findByDeparture(from);
    }

    /**selects all flights by arrival*/
    public List<Flight> getFlightsByArrival(String to){
        return flightRepository.findByArrival(to);
    }

    /**create new flight*/
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }

    /**updates a flight by  id */
    /** id and iddisp cannot be updated!!!*/
    public String updateFlightById(Long id, @NotNull Flight flightData){
        Flight currentFlight=flightRepository.findById(id).get();

        String ziua=flightData.getZiua();
        String from=flightData.getFrom();
        String to=flightData.getTo();

        if(ziua!=null){
            currentFlight.setZiua(ziua);
        }
        if(from!=null){
            currentFlight.setFrom(from);
        }
        if(to!=null){
            currentFlight.setTo(to);
        }

        flightRepository.save(currentFlight);
        return "Flight "+id+" updated";
    }

    /** delete a flight by id */
    public String deleteFlightByID(Long id) {
      flightRepository.deleteById(id);
      return "Flight " +id + " was deleted";
    }




}
