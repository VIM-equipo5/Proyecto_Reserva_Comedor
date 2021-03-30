import { Component, Input, ViewEncapsulation } from "@angular/core";
import { NgbActiveModal } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-producto",
  styleUrls: ["./producto.component.css"],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
  template:`
  <div class="modal-header">
    <h4 class="modal-title">{{elegido.nombre}}</h4>
    <button
      type="button"
      class="close"
      aria-label="Close"
      (click)="activeModal.dismiss('Cross click')"
    ></button>
  </div>
  <div class="modal-body">
    <div class="container">
      <div class="row">
        <div class="col-5">
          <div class="imagen-plato">
            <img [src]="elegido.imagen" class="img-fluid" alt="Responsive image">
          </div>
        </div>
        <div class="col-7">
          <div class="row">
            <div class="col-6">
              <h5>Nombre</h5>
              <p>{{elegido.nombre}}</p>
            </div>
            <div class="col-6" *ngIf=" elegido typeof Plato">
              <h5>Tipo</h5>
              <p>{{elegido.tipo}}</p>
              
            </div>
          </div>
          <div class="row">
            <div class="col-12 ">
              <h5>Precio Unitario</h5>
              <p>{{elegido.precioUnitario}} €</p>
            </div>
  
          </div>
          <hr>
          <div class="row">
            <div class="col-12">
              <h5>Descripción</h5>
              <p>{{elegido.descripcion}}</p>
            </div>            
          </div>    
        </div> 
      </div>
    </div>
    

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
export class ProductoComponent{
  @Input()
  public elegido!: any;

  constructor(public activeModal: NgbActiveModal) {}
}
