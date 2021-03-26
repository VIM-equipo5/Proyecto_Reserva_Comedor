import { HttpClient, HttpHeaders, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class LoginService {
  private baseUrl = "";
  httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "POST",
      observe: "response",
    }),
  };

  
  constructor(private http: HttpClient) {}

  peticionToken(name: String, password: String): Observable<Object> {
    const headers = { 'content-type': 'application/json',
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "POST",
    observe: "response"}

    return this.http.post<any>(
      `/login`,
      JSON.stringify({ name, password }),
      {'headers': headers}
    );
  }
}
