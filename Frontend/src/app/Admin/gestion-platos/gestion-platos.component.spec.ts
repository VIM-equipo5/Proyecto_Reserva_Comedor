import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionPlatosComponent } from './gestion-platos.component';

describe('GestionPlatosComponent', () => {
  let component: GestionPlatosComponent;
  let fixture: ComponentFixture<GestionPlatosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionPlatosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionPlatosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
