import { FranjaHoraria } from "./franjaHoraria";
import { Usuario } from "./Usuario";

export class Reserva {
    idReserva!: Number;
    cantidadComensales!: Number;
    precioTotal!: Number;
    fechaReserva!: Date;
    fechaReservada!: Date;
    usuario!: Usuario;
    franjaHoraria!: FranjaHoraria;
}