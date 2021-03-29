import { Component, Input, OnInit } from "@angular/core";
import { FormArray, FormControl, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { BuscadorService } from "../service/buscador/buscador.service";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"],
})
export class NavbarComponent {
  constructor(
    private router: Router,
    private buscadorService: BuscadorService,
    private modalService: NgbModal,
  ) {}

  buscador = new FormGroup({
    productoBuscado: new FormControl(""),
  });

  ngOnInit(): void {}

  buscarProducto() {
    const productoBuscado = this.buscador.get("productoBuscado") as FormArray;

    this.buscadorService
      .getProducto("platos", productoBuscado.value)
      .subscribe((res: any) => {
        try {
          // Si no hay error, valor encontrado

        } catch (error) {
          // Ecc, lanzo siguiente peticion para bebidas

          this.buscadorService
            .getProducto("bebidas", productoBuscado.value)
            .subscribe((res: any) => {
              try{
                // Si no hay error, valor encontrado

              } catch(error){
                // No encontrado ningun valor valido, Modal con distinto msg
                this.open();
              }
            });
        }
      });
  }

  open() {
    const modalRef = this.modalService.open(NgbdModalContent, {
      centered: true,
    });
  }
  
  logout() {
    window.sessionStorage.removeItem("user");
    this.router.navigate(["/"]);
  }
}


@Component({
  selector: "ngbd-modal-content",
  template: `
    <div class="modal-header">
      <h4 class="modal-title">No encontrado.</h4>
      <button
        type="button"
        class="close"
        aria-label="Close"
        (click)="activeModal.dismiss('Cross click')"
      ></button>
    </div>
    <div class="modal-body">
      <p style="text-align=center">
        No se ha encontrado el producto buscado.
      </p>
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
  @Input() name: any;

  constructor(public activeModal: NgbActiveModal) {}
}