package com.example.demo;

import com.example.demo.model.Ticket;
import com.example.demo.utilities.PriceTickets;
import com.example.demo.utilities.TicketManager;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestTicketManager {

    @InjectMocks
    TicketManager ticketManager;




    /** metoda de test pentru scumpirea biletelor*/
    @Test
    public void  testScumpire()
    {
        List<PriceTickets> tickets =new ArrayList<>();
        tickets.add(new Ticket(1L,1L,1L,"economic",50L));
        tickets.add(new Ticket(1L,1L,1L,"economic",100L));
        tickets.add(new Ticket(1L,1L,1L,"economic",200L));

        List<PriceTickets> expectedtickets =new ArrayList<>();
        expectedtickets.add(new Ticket(1L,1L,1L,"economic",75L));
        expectedtickets.add(new Ticket(1L,1L,1L,"economic",150L));
        expectedtickets.add(new Ticket(1L,1L,1L,"economic",300L));

        ticketManager.setTickets(tickets);
        ticketManager.increadsePrices(0.5f);

        boolean result=compareTicketList(expectedtickets,ticketManager.getTickets());

        assertTrue(result);
    }


    /** metoda de test pentru ieftinirea biletelor*/
    @Test
    public void  testIeftinire()
    {
        List<PriceTickets> tickets =new ArrayList<>();
        tickets.add(new Ticket(1L,1L,1L,"economic",50L));
        tickets.add(new Ticket(1L,1L,1L,"economic",100L));
        tickets.add(new Ticket(1L,1L,1L,"economic",200L));

        List<PriceTickets> expectedtickets =new ArrayList<>();
        expectedtickets.add(new Ticket(1L,1L,1L,"economic",25L));
        expectedtickets.add(new Ticket(1L,1L,1L,"economic",50L));
        expectedtickets.add(new Ticket(1L,1L,1L,"economic",100L));

        ticketManager.setTickets(tickets);
        ticketManager.reducePrices(0.5f);

        boolean result=compareTicketList(expectedtickets,ticketManager.getTickets());

        assertTrue(result);
    }



    /** compara 2 liste de bilete (in functie de pretul fiecaruia)   */
    private Boolean compareTicketList(List<PriceTickets> tickets1, List<PriceTickets> tickets2){
        if(tickets1.size()!=tickets2.size())
            return false;
        for (int i = 0; i < tickets1.size(); i++) {
            Ticket ticket1= (Ticket) tickets1.get(i);
            Ticket ticket2= (Ticket) tickets2.get(i);

            if(!Objects.equals(ticket1.getPret(), ticket2.getPret()))
                return false;
        }
        return true;
    }

}
