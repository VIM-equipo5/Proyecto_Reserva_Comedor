import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class LoginService {
  constructor(private http: HttpClient) {}

  peticionToken(name: String, password: String) {
    let obs;
    const headers = {
      "content-type": "application/json",
      "Access-Control-Allow-Methods": "POST",
      observe: "response",
    };

    obs = this.http.options(`http://localhost:8080/login`, {
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
      `http://localhost:8080/api/usuarios/nombre/${username}`
    );
  }
}
