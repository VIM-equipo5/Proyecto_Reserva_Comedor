import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { filter } from "rxjs/operators";
import { map } from "rxjs/operators";

/* services */
import { GestionService } from 'src/app/Admin/service/gestion.service';

/* models */
import { Bebida } from 'src/app/model/Bebida';
import { Categoria } from 'src/app/model/Categoria';
import { Plato } from 'src/app/model/Plato';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  entrantes!: Observable<Plato[]>;
  primerosPlatos!: Observable<Plato[]>;
  segundosPlatos!: Observable<Plato[]>;
  postres!: Observable<Plato[]>;
  bebidas!: Observable<Bebida[]>;
  
  constructor(private gestionService: GestionService) { }

  ngOnInit(): void {
    let obsPlatos = this.gestionService.getPlatos();
    this.bebidas = this.gestionService.getBebidas();

    //this.entrantes = this.filtrarPor(1,);
  }

  filtrarPor(categoria: Number, obsPlatos: Observable<Plato[]>): Observable<Plato[]>{
    return this.gestionService.getPlatos()
    .pipe(
      map((listaPlatos: any[]) =>
        listaPlatos.filter(plato => plato.categoria.id == categoria)
      )
    );
  }

}
