import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

/* services */
import { GestionService } from '../service/gestion.service';

/* models */
import { Reserva } from 'src/app/model/Reserva';

@Component({
  selector: 'app-gestion-reservas',
  templateUrl: './gestion-reservas.component.html',
  styleUrls: ['./gestion-reservas.component.css']
})
export class GestionReservasComponent implements OnInit {
  reservas!: Observable<Reserva[]>;

  constructor(private reservasServices: GestionService) {
    
  }onstructor() { }

  ngOnInit(): void {
    this.getAllReservas();
  }

  getAllReservas(){
    this.reservas = this.reservasServices.getReservas();
  }

  eliminarReserva(idReserva: Number) {
    console.log(idReserva);
    this.reservasServices.eliminarReserva(idReserva)
    .subscribe(
      res => {
        console.log(res);
        this.getAllReservas();
      },
      err => console.error(err)
    )
  }

}
