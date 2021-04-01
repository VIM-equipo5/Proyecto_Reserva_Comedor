import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActualizarBebidaComponent } from './actualizar-bebida.component';

describe('ActualizarBebidaComponent', () => {
  let component: ActualizarBebidaComponent;
  let fixture: ComponentFixture<ActualizarBebidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarBebidaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarBebidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
