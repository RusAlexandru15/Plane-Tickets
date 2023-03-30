package com.example.demo.utilities;

import com.example.demo.model.Disponibility;
import com.example.demo.model.Flight;
import com.example.demo.repository.DispRepository;



public class DispManager {

    /**  This method automatically creates a new Disponibility entity whenever a new Flight entity is saved*/
    public void createDisponibility( Flight flight,DispRepository dispRepository )  {
        Disponibility disponibility = new Disponibility();
        disponibility.setIddisp(flight.getDisponibilityID());
        disponibility.setNrEco(100L);
        disponibility.setNrBus(100L);
        disponibility.setNrFirst(100L);
        dispRepository.save(disponibility);
    }



}
