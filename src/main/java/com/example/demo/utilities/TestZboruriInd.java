package com.example.demo.utilities;

import com.example.demo.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class TestZboruriInd {
    public static void main(String[] args) {
        List<Flight> flights =new ArrayList<>();
        flights.add(new Flight(190L,"ziua","londra","oradea",100L));
        flights.add(new Flight(190L,"ziua","oradea","timisoara",100L));
//        flights.add(new Flight(190L,"ziua","oradea","londra",100L));
//        flights.add(new Flight(190L,"ziua","londra","luxemburg",100L));
//        flights.add(new Flight(190L,"ziua","luxemburg","cluj",100L));
      //  flights.add(new Flight(191L,"ziua","timisoara","cluj",101L));
        //flights.add(new Flight(191L,"ziua","cluj","bucuresti",101L));
       // flights.add(new Flight(191L,"ziua","bucuresti","roma",101L));

        FlightFinder ff=new FlightFinder(flights);


        List<Flight> result= ff.findBestPath("londra","timisoara");

        System.out.println("####### SOLUTIE #####");
        for(Flight fl:result)
            System.out.print(fl.getFrom()+" "+fl.getTo()+"-->");

    }
}
