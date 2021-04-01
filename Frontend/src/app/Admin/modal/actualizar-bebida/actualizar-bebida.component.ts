import { Component, Input, OnInit } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Observable } from "rxjs";
import { GestionService } from "src/app/Admin/service/gestion.service";
import { Bebida } from "src/app/model/Bebida";

@Component({
  selector: "app-actualizar-bebida",
  templateUrl: "./actualizar-bebida.component.html",
  styleUrls: ["./actualizar-bebida.component.css"],
})
export class ActualizarBebidaComponent implements OnInit {
  @Input() bebida!: Bebida;
  @Input() getAllBebidas: any;

  idBebida!: Number;
  bebidaActualizada: Bebida = {
    nombre: "",
    descripcion: "",
    precioUnitario: 0,
    imagen: "",
  };

  constructor(
    private gestionService: GestionService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {}

  openModal(content: any) {
    (this.bebidaActualizada.nombre = this.bebida.nombre),
      (this.bebidaActualizada.descripcion = this.bebida.descripcion),
      (this.bebidaActualizada.precioUnitario = this.bebida.precioUnitario),
      (this.bebidaActualizada.imagen = this.bebida.imagen);

    const modalRef = this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "lg",
      centered: true,
    });
  }

  modificarBebida() {
    this.bebidaActualizada.nombre = this.bebida.nombre;
    this.gestionService
      .actualizarBebida(this.bebida.idBebida || 0, this.bebidaActualizada)
      .subscribe(
        (res) => {
          this.getAllBebidas();
        },
        (e) => {
          console.log(e);
        }
      );
  }
}
