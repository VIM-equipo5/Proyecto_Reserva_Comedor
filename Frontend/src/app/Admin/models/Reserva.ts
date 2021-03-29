import { FranjaHoraria } from "./franjaHoraria";
import { Usuario } from "./Usuario";

export class Reserva {
    idReserva!: Number;
    cantidadComensales!: Number;
    precioTotal!: Number;
    fechaReserva!: String;
    fechaReservada!: String;
    usuario!: Usuario;
    franjaHoraria!: FranjaHoraria;
}