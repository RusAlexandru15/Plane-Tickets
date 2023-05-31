import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Disponibility } from './disponibility';

@Injectable({
    providedIn: 'root'
})
export class DispService {

    //portul din SPRING BOOT 
    private findURL = "http://localhost:8080/disps/getDisp{id}";
    private baseURL = "http://localhost:8080/disps"

    constructor(private httpClient: HttpClient) { }


    //select  where userid=... 
    getDisponibility(idZbor: number): Observable<Disponibility> {
        const url = `${this.findURL}${idZbor}`;
        return this.httpClient.get<Disponibility>(url);

    }

    //select * 
    getDispsList(): Observable<Disponibility[]> {
        return this.httpClient.get<Disponibility[]>(`${this.baseURL}`)
    }


}