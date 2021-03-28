import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionBebidasComponent } from './gestion-bebidas.component';

describe('GestionBebidasComponent', () => {
  let component: GestionBebidasComponent;
  let fixture: ComponentFixture<GestionBebidasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionBebidasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionBebidasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
