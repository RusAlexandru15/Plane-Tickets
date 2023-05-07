package com.example.demo;

import com.example.demo.model.Flight;

import com.example.demo.repository.DispRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestZboruri {
    @Mock
    private FlightRepository flightRepository;

    @Mock
    private DispRepository dispRepository;

    @InjectMocks
    private FlightService flightService;

    Flight flight1;
    Flight flight2;
    private List<Flight> flightList;

    /** metoda de setup :se va apela inaintea fiecarui test  */
    @BeforeEach
    public void setUp() {
         flight1 = new Flight(1L, "ziua", "londra", "oradea", 100L);
         flight2 = new Flight(2L, "ziua", "londra", "oradea", 90L);
         flightList=new ArrayList<>();
         flightList.add(flight1);
         flightList.add(flight2);
    }

    /** metoda de test afisarea zborurilor */
    @Test
    public void testGetFlights() {
        when(flightRepository.findAll()).thenReturn(flightList);
        List<Flight> currentFlights = flightService.getFlights();

        int actualResult=currentFlights.size();
        int expectedResult=2;
        assertEquals(expectedResult, actualResult);
    }

    /** metoda de test pentru gasirea unui zbor dupa ID  */
    @Test
    public void testGetFlightByID(){
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight1));

        Flight currentFlight = flightService.getFlightById(1L);

        Assertions.assertEquals(flight1.getIdZbor(),currentFlight.getIdZbor());
        Assertions.assertEquals(flight1.getFrom(),  currentFlight.getFrom());
        Assertions.assertEquals(flight1.getTo(),  currentFlight.getTo());
    }

    /** metoda de test pentru creearea unui zbor  */
    @Test
    public void testNewFlight(){
        Flight newFlight=new Flight(5L, "ziua", "viena", "berlin", 80L);

        when(flightRepository.save(newFlight)).thenReturn(newFlight);


        Flight addedFlight= flightService.createFlight(newFlight);

        Assertions.assertNotNull(addedFlight);

        Assertions.assertEquals(5, addedFlight.getIdZbor());
        Assertions.assertEquals("viena",  addedFlight.getFrom());
        Assertions.assertEquals("berlin",  addedFlight.getTo());

    }

    /** metoda de test pentru actualizarea unui zbor (plecare + sosire)  */
    @Test
    public void testUpdateFlightV1(){
        Flight flightData=new Flight(1L, null, "viena", "cluj", 80L);
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight1));

        Flight currentFlight=flightService.updateFlightById(1L,flightData);

        Assertions.assertNotNull(currentFlight.getZiua());
        Assertions.assertEquals("viena",  currentFlight.getFrom());
        Assertions.assertEquals("cluj",  currentFlight.getTo());
    }

    /** metoda de test pentru actualizarea unui zbor (plecare + sosire+zi)  */
    @Test
    public void testUpdateFlightV2(){
        Flight flightData=new Flight(1L, "12-12-23", "viena", "cluj", 80L);
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight1));

        Flight currentFlight=flightService.updateFlightById(1L,flightData);

        Assertions.assertEquals("12-12-23",  currentFlight.getZiua());
        Assertions.assertEquals("viena",  currentFlight.getFrom());
        Assertions.assertEquals("cluj",  currentFlight.getTo());
    }

    /** metoda de test pentru stergerea unui zbor dupa ID*/
    @Test
    public void testDeleteFlight(){

        when(flightRepository.findById(1L)).thenReturn(Optional.ofNullable(flight1));
        flightService.deleteFlightByID(1L);
        verify(flightRepository, times(1)).deleteById(1L);
    }



}
