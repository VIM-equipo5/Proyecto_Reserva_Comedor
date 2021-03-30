import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { NgxSpinnerService } from 'ngx-spinner';

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
export class CestoComponent implements OnInit{
  @Input()
  public cesto!: Array<any>;
  @Input()
  public spinner!: NgxSpinnerService;
  public totalPrecio!: Number;
  

  datosReserva = new FormGroup({
    fechaReservada: new FormControl("", Validators.required),
    franjaHoraria: new FormControl("", Validators.required),
    cantidadComensales: new FormControl("", Validators.required)
  })

  constructor(private modalService: NgbModal ) {
    this.cesto = new Array<any>();    
  }

  ngOnInit(): void {
    this.spinner.hide();
  }

  calcularPrecioTotal(){
    debugger
    let total = 0;
    this.cesto.forEach(producto => total += producto.precioUnitario);
    this.totalPrecio = total;
  }

  /* Botón finalizar pedido */
  finalizarPedido(){
    /* Obtener datos del formulario */
    debugger
    let user = JSON.parse(window.sessionStorage.getItem('user') || "");
    console.log(user);
    user = user.replace(/{}/,'');
    let body = `{ `;
    
    Object.keys(this.datosReserva.controls).forEach((key) =>{
      body += `"${key}":"${this.datosReserva.controls[key].value}",`;
    });

    /* Petición la base de datos */

    /* Limpiar variable local del cesto y totalPrecio */

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
