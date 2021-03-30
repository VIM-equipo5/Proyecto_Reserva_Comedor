import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

/* services */
import { GestionService } from '../service/gestion.service';

/* models */
import { Bebida } from 'src/app/model/Bebida';

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

  buscarBebida(idBebida: Number) {
    this.bebidasServices.eliminarBebida(idBebida);
  }

  eliminarBebida(idBebida: Number) {
    this.bebidasServices.eliminarBebida(idBebida);
    this.getAllBebidas();
  }

}
