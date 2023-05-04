package com.example.demo.service;

import com.example.demo.model.Disponibility;
import com.example.demo.model.Flight;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DispRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.utilities.DispManager;
import com.example.demo.utilities.TicketManager;
import com.example.demo.utilities.PriceTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/** service class for the tickets */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private DispRepository dispRepository;

    //doar pentru scumpiri/ieftiniri
    private TicketManager ticketManager;
    private DispManager dispModifier;

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
        //gasesc zborul pentru care se cumpara bilet
        Flight flight = flightRepository.findById(t.getIdZbor()).get();

        //singleton principle
        if (dispModifier == null) {
            dispModifier = new DispManager();
        }

        Disponibility disponibility= dispModifier.modifyDisponibility(t,flight, dispRepository);
        //salvez disponibilitatea
        dispRepository.save(disponibility);

        return ticketRepository.save(t);
    }


    // TicketManager
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


    /**
     * reduces prices for all tickets  for a certain flight
     */
    public String priceReducesByFlightID(Long id) {
        List<Ticket> tickets = this.getTicketsByFlightID(id);//iau lista de bilete (pe baza id-ului unui zbor) din baza de date
        if (tickets.size() == 0)
            return "Nu sunt bilete pentru zborul " + id;
        else {
            //singleton principle
            if (ticketManager == null) {
                ticketManager = new TicketManager();
            }
            tickets.forEach(ticketManager::addElement);

            ticketManager.reducePrices(0.5F); //ieftinire cu 50%

            for (PriceTickets element : ticketManager.getTickets()) {
                Ticket currentTicket = (Ticket) element;
                ticketRepository.save(currentTicket);
            }
            return "Toate bilete zborului " + id + " reduce cu succes!";
        }
    }


}
