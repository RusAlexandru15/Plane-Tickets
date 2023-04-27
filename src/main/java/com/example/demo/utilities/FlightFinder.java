package com.example.demo.utilities;
import com.example.demo.model.Flight;
import java.util.List;


/** class that generates routes for indirect flights using a list of all flights and a FlightGraph field */
public class FlightFinder {
    private List<Flight> allFlights;
    private FlightGraph flightGraph;


    public FlightFinder(List<Flight> allFlights){
        this.allFlights=allFlights;

    }

    /** this method uses the FlightGraph field to generate the indirect route given the departure(String from) and the arrival(String to)  */
    public  List<Flight> findBestPath(String from,String to){
        //singleton principle
        if (flightGraph == null) {
            flightGraph = new FlightGraph(this.allFlights);
        }
        return flightGraph.findPath(from,to);
    }



}
