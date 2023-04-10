package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.utilities.TicketManager;
import com.example.demo.utilities.PriceTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    private TicketManager ticketManager;

    /**
     * selects all tickets by flyID
     */
    public List<Ticket> getTicketsByFlightID(Long id) {
        return ticketRepository.findByFlightId(id);
    }

    /**
     * create new ticket
     */
    public Ticket createTicket(Ticket t) {
        return ticketRepository.save(t);
    }


    /**
     * increases prices for all tickets  for a certain flight
     */
    public String priceIncreaseByFlightID(Long id) {
        List<Ticket> tickets = this.getTicketsByFlightID(id);//iau lista de bilete (pe baza id-ului unui zbor) din baza de date
        if (tickets.size() == 0)
            return "Nu sunt bilete pentru zborul " + id;
        else {
            //singleton principle
            if (ticketManager == null) {
                ticketManager = new TicketManager();
            }
            tickets.forEach(ticketManager::addElement);

            ticketManager.increadsePrices(0.5F); //scumpire cu 50%

            for (PriceTickets element : ticketManager.getTickets()) {
                Ticket currentTicket = (Ticket) element;
                ticketRepository.save(currentTicket);
            }
            return "Toate bilete zborului " + id + " scumpite cu succes!";
        }
    }

}
