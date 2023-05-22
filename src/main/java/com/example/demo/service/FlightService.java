package com.example.demo.service;

import com.example.demo.bussinessLogic.FlightValidator;
import com.example.demo.model.Flight;
import com.example.demo.repository.DispRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.bussinessLogic.DispManager;

import com.example.demo.repository.TicketRepository;
import com.example.demo.utilities.FlightFinder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/** service class for the flights */
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private DispRepository dispRepository;
    @Autowired
    private TicketRepository ticketRepository;

    private FlightValidator flightValidator;

    private FlightFinder flightFinder;

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
    public Flight createFlight(Flight flight)
    {
        DispManager dispGenerator=new DispManager();

        String ziua=flight.getZiua();
        String from=flight.getFrom();
        String to=flight.getTo();

        if (flightValidator == null) {
            flightValidator = new FlightValidator();
        }

        //verifica datele de intrare daca sunt corecte
        if(!flightValidator.validateFligh(ziua,from,to))
            return null;

        dispGenerator.createDisponibility(flight,dispRepository);
        return flightRepository.save(flight);
    }


    /**updates a flight by  id
    /** id and iddisp cannot be updated!!!*/
    public Flight updateFlightById(Long id, @NotNull Flight flightData){
        Flight currentFlight=flightRepository.findById(id).get();

        if (flightValidator == null) {
            flightValidator = new FlightValidator();
        }

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

        //verifica datele de intrare daca sunt corecte
        if(!flightValidator.validateFligh(ziua,from,to))
            return null;

        flightRepository.save(currentFlight);
        return currentFlight;
    }


    /** delete a flight by id and its disponibility
     * also delelte all the tickets and disponibility associated*/
    public String deleteFlightByID(Long id) {
        Flight currentFlight=flightRepository.findById(id).get();
        Long iddisp=currentFlight.getDisponibilityID();
      flightRepository.deleteById(id);
      dispRepository.deleteById(iddisp);
      ticketRepository.deleteByIdZbor(id);
      return "Flight " +id + " was deleted";
    }

    /** finds the indirect routes using the utility class FlightFinder */
    public List<Flight> indirectFlights(String from,String to){
        //if (flightFinder == null) {
            flightFinder = new FlightFinder();
        //}
        flightFinder.setAllFlights(flightRepository.findAll());
        return flightFinder.findBestPath(from,to);
    }



}
