package com.example.demo.utilities;
import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private List<PriceTickets> tickets;

    public TicketManager(){
        this.tickets=new ArrayList<>();
    }

    public void addElement(PriceTickets item){
       this.tickets.add(item);
    }

    public void removeElement(PriceTickets item){
        this.tickets.remove(item);
    }


    public List<PriceTickets> getTickets() {
        return this.tickets;
    }

    public void increadsePrices(float amount){
        this.tickets.forEach((element) -> element.priceIncrease(amount));
    }

    public void reducePrices(float amount){
        this.tickets.forEach((element) -> element.priceReduce(amount));
    }


}
