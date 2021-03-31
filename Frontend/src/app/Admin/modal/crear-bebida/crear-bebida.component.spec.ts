import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearBebidaComponent } from './crear-bebida.component';

describe('CrearBebidaComponent', () => {
  let component: CrearBebidaComponent;
  let fixture: ComponentFixture<CrearBebidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearBebidaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearBebidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
