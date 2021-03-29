import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { GestionService } from '../service/gestion.service';
import { Bebida } from '../models/Bebida';

@Component({
  selector: 'app-gestion-bebidas',
  templateUrl: './gestion-bebidas.component.html',
  styleUrls: ['./gestion-bebidas.component.css']
})
export class GestionBebidasComponent implements OnInit {
  bebidas!: Observable<Bebida[]>;

  constructor(private bebidasServices: GestionService) {

  }

  ngOnInit(): void {
    this.getAllBebidas();
  }

  getAllBebidas(){
    this.bebidasServices.getBebidas().subscribe((res) => {
      console.log('Res', res);
    })
    this.bebidas = this.bebidasServices.getBebidas();
  }

  crearBebida(){
    console.log("crear bebidas")
  }

}
