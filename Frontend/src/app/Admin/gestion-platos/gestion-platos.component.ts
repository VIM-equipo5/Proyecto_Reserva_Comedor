import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { GestionService } from '../service/gestion.service';
import { Plato } from '../models/Plato';

@Component({
  selector: 'app-gestion-platos',
  templateUrl: './gestion-platos.component.html',
  styleUrls: ['./gestion-platos.component.css']
})
export class GestionPlatosComponent implements OnInit {
  platos!: Observable<Plato[]>;

  constructor(private platosServices: GestionService) {}
  ngOnInit(): void {
    this.getAllPlatos();
  }

  getAllPlatos(){
    this.platos = this.platosServices.getPlatos();
  }

  crearPlato(){
    console.log("crear platos")
  }
  
}
