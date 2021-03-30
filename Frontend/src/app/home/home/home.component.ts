import { Component, Input, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { filter, take, takeWhile, toArray } from "rxjs/operators";
import { map } from "rxjs/operators";

/* services */
import { GestionService } from "src/app/Admin/service/gestion.service";

/* models */
import { Bebida } from "src/app/model/Bebida";
import { Categoria } from "src/app/model/Categoria";
import { Plato } from "src/app/model/Plato";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  @Input()
  elegido!: String;

  entrantes!: Observable<Plato[]>;
  primerosPlatos!: Observable<Plato[]>;
  segundosPlatos!: Observable<Plato[]>;
  postres!: Observable<Plato[]>;
  bebidas!: Observable<Bebida[]>;
  obsPlatos!: Observable<Plato[]>;
  
  constructor(private gestionService: GestionService) {}

  ngOnInit(): void {
    this.obsPlatos = this.gestionService.getPlatos();
    this.bebidas = this.gestionService.getBebidas();

    this.entrantes = this.filtrarPor(1);
    this.primerosPlatos = this.filtrarPor(2);
    this.segundosPlatos = this.filtrarPor(3);
    this.postres = this.filtrarPor(4);
    setInterval(function(){ 
      document.getElementById("btn-hide")?.click()
      ;}, 1000);
  }

  filtrarPor(categoria: Number): Observable<Plato[]> {
    return this.obsPlatos.pipe(
        map((listaPlatos: any[]) =>
          listaPlatos.filter((plato) => plato.categoria.idCategoria == categoria)
        )
      );
  }
}
