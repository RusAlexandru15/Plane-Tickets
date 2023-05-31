import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientFlightListComponent } from './client-flight-list.component';

describe('ClientFlightListComponent', () => {
  let component: ClientFlightListComponent;
  let fixture: ComponentFixture<ClientFlightListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientFlightListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientFlightListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
