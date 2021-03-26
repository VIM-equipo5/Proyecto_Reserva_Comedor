import { Component, OnInit } from '@angular/core';
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
  submitted = false;

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
  }

  nuevoUsuario(): void {
    this.submitted = false;
    this.usuario = new Usuario();
  }

  save() {
    this.usuarioService.crearUsuario(this.usuario).subscribe(data => {
      console.log(data);
      this.usuario = new Usuario();
      this.goToLogin();
    },
    error => console.log(error));
  }

  onSubmit(){
    this.submitted = true;
    this.save();
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
