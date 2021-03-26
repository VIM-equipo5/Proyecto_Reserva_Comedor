import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallesCuentaComponent } from './detalles-cuenta.component';

describe('DetallesCuentaComponent', () => {
  let component: DetallesCuentaComponent;
  let fixture: ComponentFixture<DetallesCuentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetallesCuentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetallesCuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
