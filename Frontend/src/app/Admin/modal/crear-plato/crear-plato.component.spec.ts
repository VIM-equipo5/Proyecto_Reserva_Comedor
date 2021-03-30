import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearPlatoComponent } from './crear-plato.component';

describe('CrearPlatoComponent', () => {
  let component: CrearPlatoComponent;
  let fixture: ComponentFixture<CrearPlatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearPlatoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearPlatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
