import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Usuario } from '../usuario/model/usuarios';
import { UsuarioService } from '../usuario/service/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private loginService: LoginService, private router: Router) { 
  }

  ngOnInit(): void {

  }

  onSubmit(){
    const token = this.getToken();

    console.log(token);
  }
  
  getToken() {
    this.loginService
    /* Crendeciales para obtener el token de nivel de usuario basico 
      En teoría, estas credenciales no son accesible para el usuario */
    .peticionToken("rolUsuario","NoMeRobes").subscribe(data => {
      console.log(data);
    },
    error => console.log(error));
  }
}
