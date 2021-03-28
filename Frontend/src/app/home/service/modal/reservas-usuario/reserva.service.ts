import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private api = "http://localhost:8080/api";
  constructor(private http: HttpClient) { }

  getReservas(): Observable<any>{
    return this.http.get(`${this.api}/reservas`);
  }
}
