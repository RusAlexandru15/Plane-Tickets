import { Component } from '@angular/core';


@Component({
    selector: 'app-container', //se poate folosi ca html tag
    templateUrl: './container.component.html', //cum o sa arate 
    styleUrls: ['./container.component.css'] //stil
  })


//o exportez sa o pot folosi
export class ContainerComponent{
    constructor(){}

    ngOnInit(): void {

    }
 
}