import { Component, Input, OnInit, Output } from "@angular/core";
import { FormArray, FormControl, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"],
})
export class NavbarComponent {
  @Input()
  public cesto!: Array<any>;

  constructor(
    private router: Router,
    private modalService: NgbModal,
  ) {}

  buscador = new FormGroup({
    productoBuscado: new FormControl(""),
  });

  ngOnInit(): void {}

  buscarProducto() {
    const productoBuscado = this.buscador.get("productoBuscado") as FormArray;
    const idProducto = productoBuscado.value || "body";
    const element = document.getElementById(`${idProducto.toLowerCase()}`);
    if (element) {
      element.scrollIntoView({
        block: "center",
        behavior: "smooth",
      });
    } else
      this.noEncontradoProducto();
  }

  noEncontradoProducto() {
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
      <h4 class="modal-title">No encontrado</h4>
    </div>
    <div class="modal-body">
      <p style="text-align=center">El producto buscado no se ha encontrado.</p>
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
