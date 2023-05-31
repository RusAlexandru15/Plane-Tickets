import { Component } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

//AI EXEMPLU DE EVENT BINDING
export class SearchComponent {
  constructor(){}
  
  ngOnInit():void{}

  searchValue:string='';


  // ngModel nu are nevoie de ea
  changeSearchValue(eventData:Event){
    //o afiseaza pe site
   //console.log((<HTMLInputElement>eventData.target).value);

   //salvez stingu introdus de user in field-ul searchValue
   this.searchValue=(<HTMLInputElement>eventData.target).value;//o afiseaza pe site

 }

}
