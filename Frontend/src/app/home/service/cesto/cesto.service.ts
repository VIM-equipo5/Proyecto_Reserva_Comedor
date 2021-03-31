import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reserva } from 'src/app/model/Reserva';

@Injectable({
  providedIn: 'root'
})
export class CestoService {

  private api = "http://localhost:8080/api";
  constructor(private http: HttpClient) { }

  getFranja(id: Number): Observable<any>{
    return this.http.get(`${this.api}/franjashorarias/${id}`);
  }

  createReserva(reserva: string): Observable<Object> {
    const headers = {"content-type": "application/json"};
    return this.http.post(`${this.api}/reservas`,JSON.parse(reserva),{headers: headers});
  }
}
