import {NgModule} from '@angular/core'
import {Routes,RouterModule} from '@angular/router'
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';

const routes:Routes =[
    {path: "flights",component : FlightListComponent},

    //{path:'',redirectTo:'create-flight',component: CreateFlightComponent},
    
   // {path:'',redirectTo:'flights',pathMatch:'full'},  //pagina principala

    {path:'update-flight/:id',component:UpdateFlightComponent} ,// ma duce la pagina update flight
    {path:'delete-flight/:id',component:UpdateFlightComponent} // ma duce la pagina update flight
   
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports :[RouterModule]
})
export class AppRoutingModule {}