import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Slider4Component } from './slider4.component';

describe('Slider4Component', () => {
  let component: Slider4Component;
  let fixture: ComponentFixture<Slider4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Slider4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Slider4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
