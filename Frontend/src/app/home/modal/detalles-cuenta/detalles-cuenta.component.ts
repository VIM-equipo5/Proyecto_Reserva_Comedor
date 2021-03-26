import { Component, ViewEncapsulation } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";

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
export class DetallesCuentaComponent{

  constructor(private modalService: NgbModal) {}

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "xl",
      centered: true,
      scrollable: true
    });
  }

}
