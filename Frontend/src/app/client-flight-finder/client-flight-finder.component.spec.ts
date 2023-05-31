import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientFlightFinderComponent } from './client-flight-finder.component';

describe('ClientFlightFinderComponent', () => {
  let component: ClientFlightFinderComponent;
  let fixture: ComponentFixture<ClientFlightFinderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientFlightFinderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientFlightFinderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
