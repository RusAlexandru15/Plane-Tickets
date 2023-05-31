import { Component } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service'

@Component({
  selector: 'app-client-flight-finder',
  templateUrl: './client-flight-finder.component.html',
  styleUrls: ['./client-flight-finder.component.css']
})
export class ClientFlightFinderComponent {
  departure: string = '';
  arrival: string = '';
  flights: Flight[] = [];

  constructor(private flightService: FlightService) { }

  ngOnInit(): void {
  }

  public findBestPath(departure: string, arrival: string) {
    this.flights = [];
    if (departure == '' || arrival == '') {
      this.flights = [];
      alert("invalid input");
    }
    else {
      this.flightService.getBestFlightPath(departure, arrival).subscribe(data => {
        this.flights = data;
        alert(this.flights.length);
      });

    }
    arrival = ''
    departure = ''
  }


}
