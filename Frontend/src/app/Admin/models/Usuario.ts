import { Rol } from "./Rol";

export class Usuario {
    idUsuario!: Number;
    nombreUsuario!: String;
    contraseña!: String;
    nombre!: String;
    apellido!: String;
    fechaNacimiento!: Date;   //Hay que ver cómo poner esto bien
    telefono!: Number;
    rol!: Rol;
    dni!: String;
}