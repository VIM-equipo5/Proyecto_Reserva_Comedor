import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Bebida } from 'src/app/model/Bebida';
import { Plato } from 'src/app/model/Plato';

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

  eliminarPlatos(idPlato: Number) {
    return this.http.delete(`${this.api}/platos/${idPlato}`);
  }

  actualizarPlato(idPlato: Number, platoActualizado: Plato): Observable<any> {
    return this.http.put(`${this.api}/platos/${idPlato}`, platoActualizado);
  }

  guardarPlato(plato: Plato) {
    return this.http.post(`${this.api}/platos`, plato);
  }

  /*Bebidas*/
  getBebidas(): Observable<any>{
    return this.http.get(`${this.api}/bebidas`);
  }

  //getBebidas(id: string): Observable<any>{
  //  return this.http.get(`${this.api}/bebidas/${id}`);
  //}

  eliminarBebida(idBebida: Number) {
    return this.http.delete(`${this.api}/bebidas/${idBebida}`);
  }

  actualizarBebida(idBebida: Number, bebidaActualizada: Bebida): Observable<any> {
    return this.http.put(`${this.api}/bebidas/${idBebida}`, bebidaActualizada);
  }

  guardarBebida(bebida: Bebida) {
    return this.http.post(`${this.api}/bebidas`, bebida);
  }

  /*Reservas*/
  getReservas(): Observable<any>{
    return this.http.get(`${this.api}/reservas`);
  }

  /*Usuarios*/
  getUsuarios(): Observable<any>{
    return this.http.get(`${this.api}/usuarios`);
  }
}
