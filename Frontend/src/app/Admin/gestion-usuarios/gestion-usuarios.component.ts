import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { GestionService } from '../service/gestion.service';
import { Usuario } from '../models/Usuario';

@Component({
  selector: 'app-gestion-usuarios',
  templateUrl: './gestion-usuarios.component.html',
  styleUrls: ['./gestion-usuarios.component.css']
})
export class GestionUsuariosComponent implements OnInit {
  usuarios!: Observable<Usuario[]>;

  constructor(private usuariosServices: GestionService) {
    
  }onstructor() { }

  ngOnInit(): void {
    this.getAllUsuarios();
  }

  getAllUsuarios(){
    this.usuarios = this.usuariosServices.getUsuarios();
  }

  crearPlato(){
    console.log("crear usuarios")
  }

}
