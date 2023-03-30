package com.example.demo.controller;


import com.example.demo.model.Flight;
import com.example.demo.model.Ticket;

import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;


    @PostMapping("/tickets/new")
    public Ticket saveTicketControlled(@RequestBody Ticket t){
        return ticketService.createTicket(t);
    }


    @GetMapping("/tickets/ticketsByFlight{id}")
    public List<Ticket> getTicketByFlightControlled(@PathVariable Long id){
        return  ticketService.getTicketsByFlightID(id);
    }

    @PutMapping("/tickets/increaseTicketsByFlight{id}")
    public String priceIncreaseByFlightID(@PathVariable Long id){
        return ticketService.priceIncreaseByFlightID(id);
    }

}
