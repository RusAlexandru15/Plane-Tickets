import { Component ,Input} from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
   constructor(){}

   ngOnInit(): void {}

   @Input() all: number=0;
   @Input() regular:number=0;
   @Input() premium:number=0;
}
