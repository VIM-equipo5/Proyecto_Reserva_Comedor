import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Categoria } from 'src/app/model/Categoria';
import { Plato } from 'src/app/model/Plato';
import { GestionService } from '../../service/gestion.service';

@Component({
  selector: 'app-crear-plato',
  templateUrl: './crear-plato.component.html',
  styleUrls: ['./crear-plato.component.css'],
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

  constructor(private modalService: NgbModal, private gestionService: GestionService) { }

  ngOnInit(): void {

  }

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "sm",
      centered: true
    });
  }

  plato: Plato = {
    descripcion: '',
    imagen: '',
    nombre: '',
    precioUnitario: 0,
    idPlato: 0,
    tipo: '',
    idCategoria: 0
  };

  guardarNuevoPlato() {
    delete this.plato.idPlato;
    this.gestionService.guardarPlato(this.plato)
    .subscribe(
      res => {
        console.log(res);
      },
      err => console.error(err)
    )
  }

}
