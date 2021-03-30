import { Component, Input, ViewEncapsulation } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-cesto',
  templateUrl: './cesto.component.html',
  styleUrls: ['./cesto.component.css'],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class CestoComponent {
  @Input()
  public cesto!: Array<any>;
  public totalPrecio!: Number;

  constructor(private modalService: NgbModal) {
    this.cesto = new Array<any>();    
  }

  calcularPrecioTotal(){
    debugger
    let total = 0;
    this.cesto.forEach(producto => total += producto.precioUnitario);
    this.totalPrecio = total;
  }

  finalizarPedido(){
    /* Peticióna la base de datos */

    /* Reinicio de variable local del cesto */
    console.log("hola")
  }

  openXl(content: any) {
    if(this.cesto.length > 0)
      this.calcularPrecioTotal();
    const modalRef = this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "xl",
      centered: true,
      scrollable: true
    });
  }
}
