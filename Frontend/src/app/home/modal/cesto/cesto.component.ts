import { Component, Input, OnInit, ViewEncapsulation } from "@angular/core";
import { FormArray, FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { CestoService } from "../../service/cesto/cesto.service";

@Component({
  selector: "app-cesto",
  templateUrl: "./cesto.component.html",
  styleUrls: ["./cesto.component.css"],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class CestoComponent implements OnInit {
  @Input()
  public cesto!: Array<any>;
  @Input()
  public totalPrecio!: Number;

  datosReserva = new FormGroup({
    fechaReservada: new FormControl("", Validators.required),
    franjaHoraria: new FormControl("", Validators.required),
    cantidadComensales: new FormControl("", Validators.required),
  });

  constructor(
    private cestoService: CestoService,
    private router: Router,
    private modalService: NgbModal
  ) {
    this.cesto = new Array<any>();
  }

  ngOnInit(): void {}

  borrarProductoCesto(nombre: String) {
    debugger;
    this.cesto.splice(
      this.cesto.findIndex((item) => item.nombre == nombre),
      1
    );
  }

  calcularPrecioTotal() {
    let total = 0;
    this.cesto.forEach((producto) => (total += producto.precioUnitario));
    this.totalPrecio = total;
  }

  /* Botón finalizar pedido */
  finalizarPedido() {
    let idFranja = this.datosReserva.controls["franjaHoraria"].value;

    /* Peticiones a la base de datos */
    this.cestoService.getFranja(idFranja).subscribe(
      (franja) => {
        let user = JSON.parse(window.sessionStorage.getItem("user") || "");
        franja.franjaInicio = parseInt(franja.franjaInicio.replace(/:/g, ""));
        franja.franjaFin = parseInt(franja.franjaFin.replace(/:/g, ""));

        let body = {
          cantidadComensales: this.datosReserva.controls["cantidadComensales"]
            .value,
          precioTotal: this.totalPrecio,
          fechaReservada: this.datosReserva.controls["fechaReservada"].value,
          usuario: user,
          franjaHoraria: franja,
        };

        let reserva = JSON.stringify(body).replace("password",'contraseña');
        this.cestoService.createReserva(reserva).subscribe(
          (res) => {
            /* Limpiar variable local del cesto y totalPrecio */
            this.modalReserva("Reserva","¡La reserva se ha realizado con exito!");
            this.cesto = new Array<any>();
            this.totalPrecio = 0;
            this.reloadCurrentRoute();
          },
          (e) => {
            console.log(e);
          }
        );
      },
      (e) => {
        console.log("Franja no encontrada");
      }
    );
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
}

  openXl(content: any) {
    if (this.cesto.length > 0) this.calcularPrecioTotal();
    const modalRef = this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "xl",
      centered: true,
      scrollable: true,
    });
  }

  modalReserva(titulo: String,msg: String) {
    const modalRef = this.modalService.open(NgbdModalContent, {
      centered: true,
    });
    modalRef.componentInstance.titulo = titulo;
    modalRef.componentInstance.msg = msg;
  }
}


/* Modal auxiliar */
@Component({
  selector: "ngbd-modal-content",
  template: `
    <div class="modal-header">
      <h4 class="modal-title">{{titulo}}</h4>
      <button
        type="button"
        class="close"
        aria-label="Close"
        (click)="activeModal.dismiss('Cross click')"
      ></button>
    </div>
    <div class="modal-body">
      <p style="text-align=center">{{msg}}</p>
    </div>
    <div class="modal-footer">
      <button
        type="button"
        class="btn btn btn-principal"
        (click)="activeModal.close('Close click')"
      >
        Cerrar
      </button>
    </div>
  `,
})
export class NgbdModalContent {
  @Input() titulo!: String;
  @Input() msg!: String;

  constructor(public activeModal: NgbActiveModal) {}
}
