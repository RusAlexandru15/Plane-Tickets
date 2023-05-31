import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //portul din SPRING BOOT 
  private baseURL="http://localhost:8080/users"

  
  constructor(private httpClient:HttpClient) { }


  //select * 
  getUsersList():Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`)
  }


  
 

}

//http://localhost:8080/users
//am declara in appModule noul modul hhtpClientModuel
//injectez flightService in Flight List component