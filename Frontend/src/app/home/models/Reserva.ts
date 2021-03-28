import { Usuario } from "src/app/Login/model/usuarios";
import { FranjaHoraria } from "./FranjaHoraria";

export class Reserva {
    idReserva!: Number;
    cantidadComensales!: Number;
    precioTotal!: Number;
    fechaReserva!: String;
    fechaReservada!: String;
    usuario!: Usuario;
    franjaHoraria!: FranjaHoraria;
}
