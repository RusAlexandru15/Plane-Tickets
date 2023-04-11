package com.example.demo.utilities;
import com.example.demo.model.Flight;
import java.util.List;


public class FlightFinder {
    private List<Flight> allFlights;
    private FlightGraph flightGraph;


    public FlightFinder(List<Flight> allFlights){
        this.allFlights=allFlights;

    }


    public  List<Flight> findBestPath(String from,String to){
        //singleton principle
        if (flightGraph == null) {
            flightGraph = new FlightGraph(this.allFlights);
        }
        return flightGraph.findPath(from,to,allFlights);
    }



}
