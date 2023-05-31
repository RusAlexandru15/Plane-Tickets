import { Component } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-create-flight',
  templateUrl: './create-flight.component.html',
  styleUrls: ['./create-flight.component.css']
})
export class CreateFlightComponent {

  flight: Flight = new Flight();
  constructor(private flightService: FlightService) { }

  ngOnInit(): void {

  }

  //apeleaza flight service
  saveFlight() {
    this.flightService.createFlight(this.flight).subscribe(data => {
      console.log(data);
    },
      error => console.log(error));
  }

  //metoda care se apeleaza la buton
  onSubmit() {

    this.saveFlight();

  }
}
