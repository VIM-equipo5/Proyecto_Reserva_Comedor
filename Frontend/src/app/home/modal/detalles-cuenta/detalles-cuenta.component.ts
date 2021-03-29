import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Usuario } from 'src/app/model/Usuarios';

@Component({
  selector: 'app-detalles-cuenta',
  templateUrl: './detalles-cuenta.component.html',
  styleUrls: ['./detalles-cuenta.component.css'],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class DetallesCuentaComponent implements OnInit{
  detalle!: Usuario;

  constructor(private modalService: NgbModal) {}

  ngOnInit(): void{
    this.detalle = JSON.parse(window.sessionStorage.getItem("user")|| "{}" );
  }

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "sm",
      centered: true
    });
  }

  

}
