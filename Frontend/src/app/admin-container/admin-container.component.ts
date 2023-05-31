import { Component } from '@angular/core';
import { UserService } from '../user.service'
import { User } from '../user';

@Component({
  selector: 'app-admin-container',
  templateUrl: './admin-container.component.html',
  styleUrls: ['./admin-container.component.css']
})
export class AdminContainerComponent {
  constructor(private userService: UserService) { }

  name: string = '';
  password: string = '';
  isLoggedIn: number = 0;
  users: User[] = [];

  //user's data - le trimit la componenta client-list
  userId: number = 0;
  userName: string = '';
  userLocation: string = '';

  //isLoggedIn - 0 nelogat
  //isLoggedIn - 1 admin
  //isLoggedIn - 2 client

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers() {
    this.userService.getUsersList().subscribe(
      data => {
        this.users = data;
      },
      error => {
        console.log(error);
      }
    );
  }


  login() {
    if (this.name === 'admin' && this.password === '1234') {
      this.isLoggedIn = 1;
    } else {
      this.users.forEach(user => {
        if (user.nume == this.name && user.parola == this.password) {
          this.isLoggedIn = 2;
          this.userId = user.idClient;
          this.userName = user.nume;
          this.userLocation = user.locatie;
        }
      })
    }
    if (this.isLoggedIn == 0)
      alert("nume sau parola incorecte");
  }

}
