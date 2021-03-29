import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BuscadorService {
  api = "http://localhost:8080/api";
  constructor(private http: HttpClient) { }

  getProducto(tipoProducto: String, nombreProducto: String){
    return this.http.get(`${this.api}/${tipoProducto}/${nombreProducto}`);
  }
}
