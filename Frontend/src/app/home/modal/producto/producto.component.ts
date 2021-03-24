import { Component, ViewEncapsulation } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-producto",
  templateUrl: "./producto.component.html",
  styleUrls: ["./producto.component.css"],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .dark-modal .modal-content {
        background-color: #292b2c;
        color: white;
      }
      .dark-modal .close {
        color: white;
      }
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class ProductoComponent {
  constructor(private modalService: NgbModal) {}

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "xl",
    });
  }
}
