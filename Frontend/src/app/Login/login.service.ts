import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Usuario } from "./usuario/model/usuarios";

@Injectable({
  providedIn: "root",
})
export class LoginService {

  base_url = "http://localhost:8080";
  api = "http://localhost:8080/api";

  constructor(private http: HttpClient) {}

  peticionToken(name: String, password: String) {
    let obs;
    const headers = {
      "content-type": "application/json",
      "Access-Control-Allow-Methods": "POST",
      observe: "response",
    };

    obs = this.http.options(`${this.base_url}/login`, {
      headers: headers,
    });
    return obs;
  }

  //   private setSession(authResult) {
  //     const expiresAt = moment().add(authResult.expiresIn,'second');

  //     localStorage.setItem('id_token', authResult.idToken);
  //     localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
  // }

  getUsuario(username: String) {
    return this.http.get(
      `${this.api}/usuarios/nombre/${username}`
    );
  }

  createUsuario(user: string): Observable<Object> {
    const headers = {"content-type": "application/json"};
    return this.http.post(`${this.api}/usuarios`,JSON.parse(user),{headers: headers});
  }
}
