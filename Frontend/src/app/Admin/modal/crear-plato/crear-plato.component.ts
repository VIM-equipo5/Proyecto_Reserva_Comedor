import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-crear-plato',
  templateUrl: './crear-plato.component.html',
  styleUrls: ['./crear-plato.component.css'],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class CrearPlatoComponent implements OnInit {

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {

  }

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "sm",
      centered: true
    });
  }

}
