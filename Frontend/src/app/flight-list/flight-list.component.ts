import { Component } from '@angular/core';
import { Flight } from '../flight';
import {FlightService} from '../flight.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent  {

  flights: Flight[]=[];
  flight:Flight=new Flight();

  constructor(private flightService:FlightService ,private router:Router){ }

    ngOnInit() :void{
      this.getFlights();
    }

    private getFlights(){
      //chem metoda din flight service
      this.flightService.getFlightsList().subscribe(data=>{
        data.sort((a, b) => a.disponibilityID - b.disponibilityID);
      this.flights=data;
      });
    }

    private upDateFlightService(idZbor:number,flight:Flight){
      this.flightService.updateFlight(flight).subscribe(() => {
        console.log(`Flight with ID ${idZbor} updated successfully.`);
        
        
      }, error => {
        console.log(`Error updating flight with ID ${idZbor}: ${error}`);
      });
    }

       //metoda care se apeleaza la buton
       onClick(){
        this.getFlights();
      }

      updateFlight(idZbor:number ){
         this.router.navigate(['update-flight',idZbor]); //va merge la pagina de update cara si idZbor
         const flight = this.flights.find(flight => flight.idZbor === idZbor);

          if (flight) { //  null check here
             this.flight = flight;
          }
          

         this.upDateFlightService(idZbor,this.flight);
        
      }


      deleteFlight(idZbor:number){
        this.flightService.deleteFlight(idZbor).subscribe(() => {
          console.log(`Flight with ID ${idZbor} deleted successfully.`);
          
        }, error => {
          console.log(`Error deleting flight with ID ${idZbor}: ${error}`);
        });

       
      }

}
