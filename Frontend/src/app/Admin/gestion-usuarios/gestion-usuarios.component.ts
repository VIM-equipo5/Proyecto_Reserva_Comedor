import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

/* services */
import { GestionService } from '../service/gestion.service';

/* models */
import { Usuario } from 'src/app/model/Usuarios';

@Component({
  selector: 'app-gestion-usuarios',
  templateUrl: './gestion-usuarios.component.html',
  styleUrls: ['./gestion-usuarios.component.css']
})
export class GestionUsuariosComponent implements OnInit {
  usuarios!: Observable<any[]>;

  constructor(private usuariosServices: GestionService) {
    
  }

  ngOnInit(): void {
    this.getAllUsuarios();
  }

  public getAllUsuarios = () => {
    this.usuarios = this.usuariosServices.getUsuarios();
  }

  eliminarUsuario(idUsuario: Number) {
    console.log(idUsuario);
    this.usuariosServices.eliminarUsuario(idUsuario)
    .subscribe(
      res => {
        console.log(res);
        this.getAllUsuarios();
      },
      err => console.error(err)
    )
  }
}
