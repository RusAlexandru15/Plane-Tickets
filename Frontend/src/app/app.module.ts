import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';
import { ContainerComponent } from './Container/container.component';
import { NavComponent } from './nav/nav.component';
import { NotificationComponent } from './notification/notification.component';
import { SearchComponent } from './search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductsComponent } from './products/products.component';
import { FilterComponent } from './filter/filter.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { AdminContainerComponent } from './admin-container/admin-container.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { AppRoutingModule } from './app-routing.module';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { ClientFlightListComponent } from './client-flight-list/client-flight-list.component';
import { AdminDispsViewComponent } from './admin-disps-view/admin-disps-view.component';
import { ClientFlightFinderComponent } from './client-flight-finder/client-flight-finder.component';

@NgModule({
  declarations: [
    AppComponent,
    ContainerComponent,
    NavComponent,
    NotificationComponent,
    SearchComponent,
    ProductsComponent,
    FilterComponent,
    FlightListComponent,
    AdminContainerComponent,
    CreateFlightComponent,
    UpdateFlightComponent,
    ClientFlightListComponent,
    AdminDispsViewComponent,
    ClientFlightFinderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
