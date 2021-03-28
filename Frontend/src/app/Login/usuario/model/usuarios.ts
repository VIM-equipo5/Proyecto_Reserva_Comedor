import { Rol } from "./rol";

export class Usuario {
    idUsuario!: Number;
    nombreUsuario!: String;
    password!: String;
    nombre!: String;
    apellido!: String;
    dni!: String;
    telefono!: Number;
    fechaNacimiento!: String;
    rol!: Rol;
}
