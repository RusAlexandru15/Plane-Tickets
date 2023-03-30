package com.example.demo.utilities;
import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private List<priceTickets> tickets;

    public TicketManager(){
        this.tickets=new ArrayList<>();
    }

    public void addElement(priceTickets item){
       this.tickets.add(item);
    }
    public void removeElement(priceTickets item){
        this.tickets.remove(item);
    }


    public List<priceTickets> getTickets() {
        return this.tickets;
    }

    public void increadsePrices(float amount){
        this.tickets.forEach((element) -> element.priceIncrease(amount));
    }

    public void reducePrices(float amount){
        this.tickets.forEach((element) -> element.priceReduce(amount));
    }


}
