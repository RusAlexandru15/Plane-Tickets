import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  //portul din SPRING BOOT /flights/new
  private baseURL = "http://localhost:8080/flights"
  private createURL = "http://localhost:8080/flights/new"
  private updateURL = "http://localhost:8080/flights/editFlight"

  constructor(private httpClient: HttpClient) { }


  //select * 
  getFlightsList(): Observable<Flight[]> {
    return this.httpClient.get<Flight[]>(`${this.baseURL}`)

  }

  //new flight
  createFlight(flight: Flight): Observable<Object> {
    return this.httpClient.post(`${this.createURL}`, flight);
  }

  //updates a flight
  updateFlight(flight: Flight): Observable<Object> {
    return this.httpClient.put(`${this.updateURL}${flight.idZbor}`, flight);
  }

  //deletes a flight
  deleteFlight(id: number): Observable<any> {
    const url = `${this.baseURL}/deleteFlight${id}`;
    return this.httpClient.delete(url);
  }

  //finds th best path
  getBestFlightPath(from: string, to: string): Observable<Flight[]> {
    const url = `${this.baseURL}/bestPath/${from}/${to}`;
    return this.httpClient.get<Flight[]>(url);
  }


}

//http://localhost:8080/flights
//am declara in appModule noul modul hhtpClientModuel
//injectez flightService in Flight List component