import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class GestionService {

  private api = "http://localhost:8080/api";

  constructor(private http: HttpClient) { }

  /*Platos*/
  getPlatos(): Observable<any>{
    return this.http.get(`${this.api}/platos`);
  }

  //getPlatos(id: string): Observable<any>{
  //  return this.http.get(`${this.api}/platos/${id}`);
  //}

  //postPlatos

  /*Bebidas*/
  getBebidas(): Observable<any>{
    return this.http.get(`${this.api}/bebidas`);
  }

  //getBebidas(id: string): Observable<any>{
  //  return this.http.get(`${this.api}/bebidas/${id}`);
  //}

  /*Reservas*/
  getReservas(): Observable<any>{
    return this.http.get(`${this.api}/reservas`);
  }

  /*Usuarios*/
  getUsuarios(): Observable<any>{
    return this.http.get(`${this.api}/usuarios`);
  }
}
