import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from '../usuario/model/usuarios';
import { UsuarioService } from '../usuario/service/usuario.service';


/**
 *  Hay que pedir el token e insertarlo antes de hacer la peticion
 */
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  usuario: Usuario = new Usuario();
  registro = new FormGroup ({
    username: new FormControl("", Validators.required),
    password: new FormControl("", Validators.required),
    name: new FormControl("", Validators.required),
    lastname: new FormControl("", Validators.required),
    dni: new FormControl("", Validators.required),
    phone: new FormControl("", Validators.required),
    date: new FormControl("", Validators.required),
  });

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.registrarUsuario();
  }

  registrarUsuario(){
    debugger
    Object.keys(this.registro.controls).forEach(key =>{
      console.log(this.registro.controls[key].value)
    });
  }
}
