import { Component, Input, OnInit, ViewEncapsulation } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Plato } from "src/app/model/Plato";
import { GestionService } from "../../service/gestion.service";

@Component({
  selector: "app-crear-plato",
  templateUrl: "./crear-plato.component.html",
  styleUrls: ["./crear-plato.component.css"],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class CrearPlatoComponent implements OnInit {
  @Input() getAllPlatos: any;

  constructor(
    private modalService: NgbModal,
    private gestionService: GestionService
  ) {}

  ngOnInit(): void {}

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "sm",
      centered: true,
    });
  }

  plato: Plato = {
    descripcion: "",
    imagen: "",
    nombre: "",
    precioUnitario: 0,
    tipo: "",
    idCategoria: 0,
  };

  guardarNuevoPlato() {
    this.gestionService
      .getCategoriaXId(this.plato.idCategoria)
      .subscribe((res) => {
        this.plato.categoria = res;
        this.gestionService.guardarPlato(this.plato).subscribe(
          (res) => {
            this.getAllPlatos();
            console.log(res);
          },
          (err) => console.error(err)
        );
      },(err) => console.error(err));
  }
}
