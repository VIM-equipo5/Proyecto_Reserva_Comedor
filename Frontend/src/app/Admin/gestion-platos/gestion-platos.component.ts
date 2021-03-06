import { Component, Input, OnInit } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";

/* services */
import { GestionService } from "../service/gestion.service";

/* models */
import { Plato } from "src/app/model/Plato";

@Component({
  selector: "app-gestion-platos",
  templateUrl: "./gestion-platos.component.html",
  styleUrls: ["./gestion-platos.component.css"],
})
export class GestionPlatosComponent implements OnInit {
  platos!: Observable<Plato[]>;

  constructor(private platosServices: GestionService) {}

  ngOnInit(): void {
    this.getAllPlatos();
  }

  public getAllPlatos = () => {
    this.platosServices.getPlatos().subscribe((res) => {
      console.log("Res", res);
    });
    this.platos = this.platosServices.getPlatos();
  };

  eliminarPlato(idPlato: Number) {
    console.log(idPlato);
    this.platosServices.eliminarPlatos(idPlato).subscribe(
      (res) => {
        console.log(res);
        this.getAllPlatos();
      },
      (err) => console.error(err)
    );
  }
}
