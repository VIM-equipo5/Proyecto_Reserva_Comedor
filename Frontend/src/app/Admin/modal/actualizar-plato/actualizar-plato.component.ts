import { Component, Input, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Plato } from 'src/app/model/Plato';
import { GestionService } from '../../service/gestion.service';

@Component({
  selector: 'app-actualizar-plato',
  templateUrl: './actualizar-plato.component.html',
  styleUrls: ['./actualizar-plato.component.css']
})
export class ActualizarPlatoComponent implements OnInit {
  @Input() plato!: Plato;
  @Input() getAllPlatos: any;

  idPlato!: Number;
  platoActualizado: Plato = {
    descripcion: "",
    imagen: "",
    nombre: "",
    precioUnitario: 0,
    tipo: "",
    idCategoria: 0,
  };

  constructor(
    private gestionService: GestionService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
  }

  openModal(content: any) {
    (this.platoActualizado.nombre = this.plato.nombre),
      (this.platoActualizado.descripcion = this.plato.descripcion),
      (this.platoActualizado.precioUnitario = this.plato.precioUnitario),
      (this.platoActualizado.imagen = this.plato.imagen);

    const modalRef = this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "lg",
      centered: true,
    });
  }

  modificarPlato() {
    this.platoActualizado.nombre = this.plato.nombre;
    this.gestionService
      .actualizarPlato(this.plato.idPlato || 0, this.platoActualizado)
      .subscribe(
        (res) => {
          this.getAllPlatos();
        },
        (e) => {
          console.log(e);
        }
      );
  }

}
