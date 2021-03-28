import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { LoginService } from "../login.service";
import { Rol } from "../usuario/model/rol";
import { Usuario } from "../usuario/model/usuarios";

/**
 *  Hay que pedir el token e insertarlo antes de hacer la peticion
 */
@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  usuario: Usuario = new Usuario();
  registro = new FormGroup({
    nombreUsuario: new FormControl("", Validators.required),
    contraseña: new FormControl("", Validators.required),
    nombre: new FormControl("", Validators.required),
    apellido: new FormControl("", Validators.required),
    dni: new FormControl("", Validators.required),
    telefono: new FormControl("", Validators.required),
    fechaNacimiento: new FormControl("", Validators.required),
  });

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    this.registrarUsuario();
  }

  registrarUsuario() {
    let body = `{ "rol": {"idRol": 2,"nombreRol": "usuario","descripcion": "Usuario llano, con autorizacion solo para realizar reservas"},`;
    Object.keys(this.registro.controls).forEach((key) => {
      body += `"${key}":"${this.registro.controls[key].value}",`;
    });
    body = JSON.stringify(`${body.slice(0, -1)} }`);

    try {
      this.loginService.createUsuario(body).subscribe((data) => {
        console.log(data);
      });
    } catch (error) {
      console.log(error);
    }
  }
}
