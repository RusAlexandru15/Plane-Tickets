import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDispsViewComponent } from './admin-disps-view.component';

describe('AdminDispsViewComponent', () => {
  let component: AdminDispsViewComponent;
  let fixture: ComponentFixture<AdminDispsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDispsViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminDispsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
