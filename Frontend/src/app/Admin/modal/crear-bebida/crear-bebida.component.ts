import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Bebida } from 'src/app/model/Bebida';
import { GestionService } from 'src/app/Admin/service/gestion.service';

@Component({
  selector: 'app-crear-bebida',
  templateUrl: './crear-bebida.component.html',
  styleUrls: ['./crear-bebida.component.css'],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})

export class CrearBebidaComponent implements OnInit {

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

  bebida: Bebida = {
    idBebida: 0,
    nombre: '',
    descripcion: '',
    precioUnitario: 0,
    imagen: ''
  };

  guardarNuevaBebida() {
    delete this.bebida.idBebida;
    this.gestionService.guardarBebida(this.bebida)
    .subscribe(
      res => {
        console.log(res);
      },
      err => console.error(err)
    )
  }

  /*modificarBebida() {
    this.gestionService.actualizarBebida(this.bebida.idBebida, this.bebida)
      .subscribe(
        res => { 
          console.log(res);
        },
        err => console.error(err)
      )
  }*/

}
