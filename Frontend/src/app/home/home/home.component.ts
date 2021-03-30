import { ThrowStmt } from "@angular/compiler";
import { Component, Input, OnInit, Output } from "@angular/core";
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Observable, Subject } from "rxjs";
import { filter, take, takeWhile, toArray } from "rxjs/operators";
import { map } from "rxjs/operators";

/* services */
import { GestionService } from "src/app/Admin/service/gestion.service";

/* models */
import { Bebida } from "src/app/model/Bebida";
import { Categoria } from "src/app/model/Categoria";
import { Plato } from "src/app/model/Plato";
import { CestoComponent } from "../modal/cesto/cesto.component";
import { ProductoComponent } from "../modal/producto/producto.component";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  public elegido!: any;
  public toCesto!: Array<any>;

  entrantes!: Observable<Plato[]>;
  primerosPlatos!: Observable<Plato[]>;
  segundosPlatos!: Observable<Plato[]>;
  postres!: Observable<Plato[]>;
  bebidas!: Observable<Bebida[]>;
  obsPlatos!: Observable<Plato[]>;

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(
    private gestionService: GestionService,
    private modalService: NgbModal
  ) {
    this.toCesto = new Array();
  }

  ngOnInit(): void {
    this.obsPlatos = this.gestionService.getPlatos();
    this.bebidas = this.gestionService.getBebidas();
    this.dtTrigger.next();

    this.entrantes = this.filtrarPor(1);
    this.primerosPlatos = this.filtrarPor(2);
    this.segundosPlatos = this.filtrarPor(3);
    this.postres = this.filtrarPor(4);
    setInterval(function () {
      document.getElementById("btn-hide")?.click();
    }, 1000);

    this.dtOptions = {
      pagingType: "full_numbers",
      pageLength: 2,
    };
  }

  filtrarPor(categoria: Number): Observable<Plato[]> {
    return this.obsPlatos.pipe(
      map((listaPlatos: any[]) =>
        listaPlatos.filter((plato) => plato.categoria.idCategoria == categoria)
      )
    );
  }

  onClickProducto(producto: any){
    this.toCesto.push(producto);
    console.log(this.toCesto)
    const modalRef = this.modalService.open(CestoComponent);
    modalRef.componentInstance.productos = this.toCesto;
  }

  masDestalles(producto: any) {
    this.elegido = producto;
    this.open();
  }

  open() {
    const modalRef = this.modalService.open(ProductoComponent, {
      backdropClass: "backdrop",
      size: "xl",
      centered: true,
      scrollable: true,
    });
    modalRef.componentInstance.elegido = this.elegido;
  }

  goToTop(){
      document.body.scrollTop = 0;
      document.documentElement.scrollTop = 0;
  }
}
