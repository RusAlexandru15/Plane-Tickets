package com.example.demo.utilities;
import com.example.demo.model.Disponibility;
import com.example.demo.model.Flight;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DispRepository;



/** class responsible for generating disponibility entities */
public class DispManager {

    /**  This method automatically creates a new Disponibility entity whenever a new Flight entity is saved*/
    public void createDisponibility( Flight flight,DispRepository dispRepository )  {
        Disponibility disponibility = new Disponibility();
        disponibility.setIddisp(flight.getDisponibilityID());
        disponibility.setNrEco(100L);
        disponibility.setNrBus(100L);
        disponibility.setNrFirst(100L);
        disponibility.setBasePrice(120L);
        dispRepository.save(disponibility);
    }

    /**  This method modifies a  disponibility entity whenever a new Tickets is saved
     * after buying a ticket , the number of available seats corresponding to a certain class(Eco/Business/First) must decrease */
    public Disponibility modifyDisponibility(Ticket ticket,Flight flight,DispRepository dispRepository){
       Disponibility disponibility=dispRepository.findById(flight.getDisponibilityID()).get();

        long nrEco=disponibility.getNrEco();
        long nrBus=disponibility.getNrBus();
        long nrFirst=disponibility.getNrFirst();


        switch (ticket.getClasa()) {
            case "eco"-> { nrEco--; disponibility.setNrEco(nrEco);}
            case "business"-> {nrBus--; disponibility.setNrBus(nrBus); }
            case "first"-> {nrFirst--; disponibility.setNrFirst(nrFirst); }
        }
        return disponibility;
    }




}
