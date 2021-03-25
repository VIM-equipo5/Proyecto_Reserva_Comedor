import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CestoComponent } from './cesto.component';

describe('CestoComponent', () => {
  let component: CestoComponent;
  let fixture: ComponentFixture<CestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CestoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
