import { Component, Input } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service'
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service'
import { DispService } from '../disp.service'
import { Disponibility } from '../disponibility';

@Component({
  selector: 'app-client-flight-list',
  templateUrl: './client-flight-list.component.html',
  styleUrls: ['./client-flight-list.component.css']
})
export class ClientFlightListComponent {
  //vin de la componenta parinte -app container
  @Input()
  public userId: number = 0;

  @Input()
  public userName: string = '';

  flights: Flight[] = [];
  copyFlights: Flight[] = [];
  flight: Flight = new Flight();

  departures: String[] = []
  arrivals: String[] = []

  tickets: Ticket[] = [];
  ticket: Ticket = new Ticket();


  disponibility: Disponibility = new Disponibility();


  departureFilter: string = '';
  arrivalFilter: string = '';

  constructor(private flightService: FlightService, private ticketService: TicketService, private dispService: DispService) { }

  ngOnInit(): void {

    this.getFlights();
    this.onClick();
  }


  private getFlights() {
    //chem metoda din flight service
    this.flightService.getFlightsList().subscribe(data => {
      data.sort((a, b) => a.disponibilityID - b.disponibilityID);
      this.flights = data;
      this.copyFlights = data;
    });
  }

  //initializez listele departures si arrival cu ajutorul listei de bilete si al listei de zboruri
  private initializeDeparturesArrivals() {
    this.departures = [];
    this.arrivals = [];

    for (let ticket of this.tickets) {
      let flight = this.copyFlights.find(f => f.idZbor == ticket.idZbor);
      if (flight) {
        this.departures.push(flight.from);
        this.arrivals.push(flight.to);
      }
    }
  }

  private getTickets() {
    //chem metoda din ticket service
    this.ticketService.getTicketsList(this.userId).subscribe(data => {
      this.tickets = data;
      this.initializeDeparturesArrivals();
    });
  }



  showTickets() {
    this.getTickets();
    this.initializeDeparturesArrivals();

  }



  private getFilteredFlightsDeparture() {
    return this.flights.filter(flight => {

      if (this.departureFilter && flight.from.indexOf(this.departureFilter) === -1) {
        return false;
      }

      return true;
    });
  }


  private getFilteredFlightsArrival() {
    return this.flights.filter(flight => {
      if (this.arrivalFilter && flight.to.indexOf(this.arrivalFilter) === -1) {
        return false;
      }
      return true;
    });
  }


  //la apasarea butonului de refresh
  onClick() {
    if (this.departureFilter == '' && this.arrivalFilter == '')
      this.getFlights();

    if (this.departureFilter != '') {
      // this.getFlights();
      this.flights = this.getFilteredFlightsDeparture();
    }

    if (this.arrivalFilter != '') {
      //  this.getFlights();
      this.flights = this.getFilteredFlightsArrival();
    }

    this.arrivalFilter = '';
    this.departureFilter = '';

  }



  //creeare biletelor
  createEcoTicket(idZbor: number) {
    this.ticket.idClient = this.userId;
    this.ticket.idZbor = idZbor;
    this.ticket.clasa = 'eco'
    this.ticket.pret = 120

    this.ticketService.createTicket(this.ticket).subscribe(data => {
      console.log(data);
    },
      error => console.log(error));
  }

  createBussTicket(idZbor: number) {
    this.ticket.idClient = this.userId;
    this.ticket.idZbor = idZbor;
    this.ticket.clasa = 'business'
    this.ticket.pret = 220

    this.ticketService.createTicket(this.ticket).subscribe(data => {
      console.log(data);
    },
      error => console.log(error));

  }

  createFirstTicket(idZbor: number) {
    this.ticket.idClient = this.userId;
    this.ticket.idZbor = idZbor;
    this.ticket.clasa = 'first'
    this.ticket.pret = 370

    this.ticketService.createTicket(this.ticket).subscribe(data => {
      console.log(data);
    },
      error => console.log(error));
  }

  //verificarea disponibilitatii
  checkEco(idZbor: number) {
    this.dispService.getDisponibility(idZbor).subscribe(disponibility => {
      if (disponibility.nrEco <= 0) {
        return true;
      } else {
        return false;
      }
    });
  }

  checkBus(idZbor: number) {
    this.dispService.getDisponibility(idZbor).subscribe(disponibility => {
      if (disponibility.nrBus <= 0) {
        return true;
      } else {
        return false;
      }
    });
  }

  checkFirst(idZbor: number) {
    this.dispService.getDisponibility(idZbor).subscribe(disponibility => {
      if (disponibility.nrFirst <= 0) {
        return true;
      } else {
        return false;
      }
    });
  }


}
