import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Observable } from "rxjs/internal/Observable";
import { filter } from "rxjs/operators";
import { map } from "rxjs/operators";


/* services */
import { ReservaService } from "../../service/modal/reservas-usuario/reserva.service";

/* models */
import { Reserva } from "src/app/model/Reserva";
import { Usuario } from "src/app/model/Usuarios";

@Component({
  selector: "app-reservas-usuario",
  templateUrl: "./reservas-usuario.component.html",
  styleUrls: ["./reservas-usuario.component.css"],
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .backdrop {
        background-color: #5cb3fd;
      }
    `,
  ],
})
export class ReservasUsuarioComponent implements OnInit {
  reservas!: Observable<Reserva[]>;

  constructor(
    private reservaService: ReservaService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getReservasUsuario();
  }

  getReservasUsuario() {
    let user = new Usuario();
    user = JSON.parse(window.sessionStorage.getItem("user") || "");
    this.reservas = this.reservaService
      .getReservas()
      .pipe(
        map((listaReservas: any[]) =>
          listaReservas.filter(
            (reserva: { usuario: { idUsuario: Number } }) =>
              reserva.usuario.idUsuario == user.idUsuario
          )
        )
      );
  }

  openXl(content: any) {
    this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "xl",
      centered: true,
      scrollable: true,
    });
  }
}
