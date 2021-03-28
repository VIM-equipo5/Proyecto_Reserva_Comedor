import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class GestionService {
  private api = "http://localhost:8080/api";
  constructor(private http: HttpClient) { }

  getPlatos(): Observable<any>{
    return this.http.get(`${this.api}/platos`);
  }

  /*TO DO getBebidas */

  /*TO DO getReservas */

  /*TO DO getUsuarios */
}
