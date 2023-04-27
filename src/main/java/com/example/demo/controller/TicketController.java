package com.example.demo.controller;

import com.example.demo.model.Ticket;

import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;


    /**creates a new ticket with information received from a requestBody*/
    @PostMapping("/tickets/new")
    public Ticket saveTicketControlled(@RequestBody Ticket t){
        return ticketService.createTicket(t);
    }

    /** returns the list of tickets related to the flight with the given id */
    @GetMapping("/tickets/ticketsByFlight{id}")
    public List<Ticket> getTicketByFlightControlled(@PathVariable Long id){
        return  ticketService.getTicketsByFlightID(id);
    }

    /** price all flight tickets with the given id */
    @PutMapping("/tickets/increaseTicketsByFlight{id}")
    public String priceIncreaseByFlightID(@PathVariable Long id){
        return ticketService.priceIncreaseByFlightID(id);
    }

    /** discounts all flight tickets with the given id */
    @PutMapping("/tickets/reduceTicketsByFlight{id}")
    public String priceReduceByFlightID(@PathVariable Long id){
        return ticketService.priceReducesByFlightID(id);
    }

}
