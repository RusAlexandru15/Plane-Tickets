import { Component } from '@angular/core';
import { Disponibility } from '../disponibility';
import { DispService } from '../disp.service'

@Component({
  selector: 'app-admin-disps-view',
  templateUrl: './admin-disps-view.component.html',
  styleUrls: ['./admin-disps-view.component.css']
})
export class AdminDispsViewComponent {

  disps: Disponibility[] = [];

  constructor(private dispService: DispService) { }

  ngOnInit(): void {
    this.getDisps();
  }

  showDisps() {
    this.getDisps();
  }

  private getDisps() {
    this.dispService.getDispsList().subscribe(data => {
      this.disps = data;
    });
  }

}
