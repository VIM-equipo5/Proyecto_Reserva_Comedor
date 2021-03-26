import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UsuarioService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }


  crearUsuario(usuario: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}/api/usuarios`,usuario);
  }
}
