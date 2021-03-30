import { TestBed } from '@angular/core/testing';

import { CestoService } from './cesto.service';

describe('CestoService', () => {
  let service: CestoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CestoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
