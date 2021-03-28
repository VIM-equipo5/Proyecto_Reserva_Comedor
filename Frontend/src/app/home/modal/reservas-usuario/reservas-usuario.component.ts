import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Observable } from 'rxjs/internal/Observable';
import { Reserva } from '../../models/Reserva';
import { ReservaService } from '../../service/modal/reservas-usuario/reserva.service';

@Component({
  selector: 'app-reservas-usuario',
  templateUrl: './reservas-usuario.component.html',
  styleUrls: ['./reservas-usuario.component.css'],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class ReservasUsuarioComponent implements OnInit{
  reservas!: Observable<Reserva[]>;

  constructor(private reservaService: ReservaService
    ,private modalService: NgbModal) {}

  ngOnInit(): void {
    this.getAllReservas();
  }

  getAllReservas(){
    this.reservas = this.reservaService.getReservas();
  }

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "xl",
      centered: true,
      scrollable: true
    });
  }

}
