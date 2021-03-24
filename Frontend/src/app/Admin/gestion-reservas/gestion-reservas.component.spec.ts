import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionReservasComponent } from './gestion-reservas.component';

describe('GestionReservasComponent', () => {
  let component: GestionReservasComponent;
  let fixture: ComponentFixture<GestionReservasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionReservasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionReservasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
