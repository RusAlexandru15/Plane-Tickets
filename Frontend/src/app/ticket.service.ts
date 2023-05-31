import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Ticket } from './ticket';

@Injectable({
    providedIn: 'root'
})
export class TicketService {

    //portul din SPRING BOOT 
    private clientURL = "http://localhost:8080/tickets/ticketsByClient";
    private createURL = "http://localhost:8080/tickets/new";



    constructor(private httpClient: HttpClient) { }


    //select  where userid=... 
    getTicketsList(clientId: number): Observable<Ticket[]> {
        const url = `${this.clientURL}${clientId}`;
        return this.httpClient.get<Ticket[]>(url);

    }

    //new Ticket
    createTicket(ticket: Ticket): Observable<Object> {
        return this.httpClient.post(`${this.createURL}`, ticket);
    }






}