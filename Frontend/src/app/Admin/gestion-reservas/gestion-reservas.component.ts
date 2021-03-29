import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { GestionService } from '../service/gestion.service';
import { Reserva } from '../models/Reserva';

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

  crearPlato(){
    console.log("crear reservas")
  }

}
