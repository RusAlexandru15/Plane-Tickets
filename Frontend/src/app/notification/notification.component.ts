import { Component } from '@angular/core';

@Component({
  selector: 'app-notification',
  //alternativa la tamplate URL SCRIU DIRECT HTML AICI
  templateUrl: "notification.component.html",
  styleUrls: ["notification.component.css"]
})

export class NotificationComponent {
    constructor(){}

    ngOnInit():void{

    }
  displayNotification:boolean = false;

  closeNotification(){
    this.displayNotification=true;
  }

}
