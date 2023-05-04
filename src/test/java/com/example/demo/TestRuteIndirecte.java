package com.example.demo;

import com.example.demo.model.Flight;
import com.example.demo.utilities.FlightFinder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestRuteIndirecte {

    @InjectMocks
    FlightFinder flightFinder;


    /** metoda de test pentru zborurile directe */
    @Test
    public void testRutaDirecta(){

        //lista zborurilor
        List<Flight> flights =new ArrayList<>();
        flights.add(new Flight(190L,"ziua","londra","oradea",100L));
        flights.add(new Flight(190L,"ziua","oradea","timisoara",100L));

        //generam rezultat asteptat
        List<Flight> expectedResult =new ArrayList<>();
        expectedResult.add(new Flight(190L,"ziua","londra","oradea",100L));

        flightFinder.setAllFlights(flights);

        List<Flight> actualResult= flightFinder.findBestPath("londra","oradea");

        boolean result=compareFlightList(actualResult,expectedResult);
        assertTrue(result);
    }


    /** metoda de test pentru zborurile indirecte */
    @Test
    public void testRutaIndirecta1(){

        //lista zborurilor
        List<Flight> flights =new ArrayList<>();
        flights.add(new Flight(190L,"ziua","londra","oradea",100L));
        flights.add(new Flight(190L,"ziua","oradea","timisoara",100L));

        //generam rezultat asteptat
        List<Flight> expectedResult =new ArrayList<>();
        expectedResult.add(new Flight(190L,"ziua","londra","oradea",100L));
        expectedResult.add(new Flight(190L,"ziua","oradea","timisoara",100L));

        flightFinder.setAllFlights(flights);

        List<Flight> actualResult= flightFinder.findBestPath("londra","timisoara");

        boolean result=compareFlightList(actualResult,expectedResult);
        assertTrue(result);
    }


    /** metoda de test pentru zborurile indirecte v2 */
    @Test
    public void testRutaIndirecta2(){
        //lista zborurilor
        List<Flight> flights =new ArrayList<>();
        flights.add(new Flight(190L,"ziua","londra","oradea",100L));
        flights.add(new Flight(190L,"ziua","oradea","timisoara",100L));
        flights.add(new Flight(190L,"ziua","timisoara","arad",100L));
        flights.add(new Flight(190L,"ziua","timisoara","bucuresti",100L));
        flights.add(new Flight(190L,"ziua","bucuresti","cluj",100L));

        //generam rezultat asteptat
        List<Flight> expectedResult =new ArrayList<>();
        expectedResult.add(new Flight(190L,"ziua","londra","oradea",100L));
        expectedResult.add(new Flight(190L,"ziua","oradea","timisoara",100L));
        expectedResult.add(new Flight(190L,"ziua","timisoara","bucuresti",100L));
        expectedResult.add(new Flight(190L,"ziua","bucuresti","cluj",100L));


        flightFinder.setAllFlights(flights);
        List<Flight> actualResult= flightFinder.findBestPath("londra","cluj");

        boolean result=compareFlightList(actualResult,expectedResult);
        assertTrue(result);
    }

    /** metoda de test pentru zborurile indirecte negasite (lista rezultat va fi goala)*/
    @Test
    public void testRutaNegasita(){
        //lista zborurilor
        List<Flight> flights =new ArrayList<>();
        flights.add(new Flight(190L,"ziua","londra","oradea",100L));
        flights.add(new Flight(190L,"ziua","oradea","timisoara",100L));

        //generam rezultat asteptat
        List<Flight> expectedResult =new ArrayList<>();


        flightFinder.setAllFlights(flights);

        List<Flight> actualResult= flightFinder.findBestPath("londra","brasov");

        boolean result=compareFlightList(actualResult,expectedResult);
        assertTrue(result);
    }



    /** compara 2 liste de zboruri (in functie de plecare si sosire)   */
    private Boolean compareFlightList(List<Flight> flights1,List<Flight> flights2){
        if(flights1.size()!=flights2.size())
            return false;
        for (int i = 0; i < flights1.size(); i++) {
            Flight flight1=flights1.get(i);
            Flight flight2=flights2.get(i);

            if(!Objects.equals(flight1.getFrom(), flight2.getFrom()) || !Objects.equals(flight1.getTo(), flight2.getTo()))
                return false;
        }
        return true;
    }




}
