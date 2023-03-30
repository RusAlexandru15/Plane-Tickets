package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.utilities.DispManager;
import com.example.demo.utilities.TicketManager;
import com.example.demo.utilities.priceTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    /**selects all tickets by flyID*/
    public List<Ticket> getTicketsByFlightID(Long id){
        return ticketRepository.findByFlightId(id);
    }

    /**create new ticket*/
    public Ticket createTicket(Ticket t)
    {
        return ticketRepository.save(t);
    }


    /**increases prices for all tickets  for a certain flight */
    public String priceIncreaseByFlightID(Long id){
        List<Ticket> tickets =this.getTicketsByFlightID(id);
        if(tickets.size()==0)
            return "Nu sunt bilete pentru zborul "+id;
        else{
            TicketManager ticketManager=new TicketManager();

            tickets.forEach(ticketManager::addElement);

            ticketManager.increadsePrices(0.5F); //scumpire cu 50%

           for(priceTickets element:ticketManager.getTickets()){
               Ticket currentTicket= (Ticket) element;
              ticketRepository.save(currentTicket);
           }

            return "Toate bilete zborului "+id +" scumpite cu succes!";
        }
    }


}
