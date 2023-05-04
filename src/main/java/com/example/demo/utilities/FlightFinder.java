package com.example.demo.utilities;
import com.example.demo.model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/** class that generates routes for indirect flights using a list of all flights and a FlightGraph field */
public class FlightFinder {
    private List<Flight> allFlights;
    private FlightGraph flightGraph;


    public FlightFinder(){
        this.allFlights=new ArrayList<>();
    }

    public FlightFinder(List<Flight> allFlights){
        this.allFlights=allFlights;
    }

    public void setAllFlights(List<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    /** this method uses the FlightGraph field to generate the indirect route given the departure(String from) and the arrival(String to)  */
    public  List<Flight> findBestPath(String from,String to){
        if(Objects.equals(from, to))
            return new ArrayList<>();

        //singleton principle
        if (flightGraph == null) {
            flightGraph = new FlightGraph(this.allFlights);
        }
        return flightGraph.findPath(from,to);
    }




}
