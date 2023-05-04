package com.example.demo.utilities;
import java.util.ArrayList;
import java.util.List;

/** is responsible for ticket management (according to PriceTickets interface) for a particular set of tickets
 * the class respects the observer pattern */
public class TicketManager {
    private List<PriceTickets> tickets;

    public TicketManager(){
        this.tickets=new ArrayList<>();
    }

    /** setter for  the managing list */
    public void setTickets(List<PriceTickets> tickets) {
        this.tickets = tickets;
    }

    /** adds a ticket to the managing list */
    public void addElement(PriceTickets item){
       this.tickets.add(item);
    }

    /** removes a ticket to the managing list */
    public void removeElement(PriceTickets item){
        this.tickets.remove(item);
    }

    /** getter for  the managing list */
    public List<PriceTickets> getTickets() {
        return this.tickets;
    }

    /** applies the price increase on the set of tickets*/
    public void increadsePrices(float amount){
        this.tickets.forEach((element) -> element.priceIncrease(amount));
    }

    /** applies the price reduce on the set of tickets*/
    public void reducePrices(float amount){
        this.tickets.forEach((element) -> element.priceReduce(amount));
    }


}
