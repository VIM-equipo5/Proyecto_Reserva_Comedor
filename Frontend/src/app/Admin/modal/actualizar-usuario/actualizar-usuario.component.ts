import { Component, Input, OnInit } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { Rol } from "src/app/model/Rol";
import { GestionService } from "../../service/gestion.service";

@Component({
  selector: "app-actualizar-usuario",
  templateUrl: "./actualizar-usuario.component.html",
  styleUrls: ["./actualizar-usuario.component.css"],
})
export class ActualizarUsuarioComponent implements OnInit {
  @Input() usuario!: any;
  @Input() getAllUsuarios: any;

  idUsuario!: Number;
  usuarioActualizado: any = {
    idUsuario: 0,
    nombreUsuario: "",
    contraseña: "a",
    nombre: "",
    apellido: "",
    dni: "",
    telefono: 0,
    fechaNacimiento: "",
    rol: new Rol(),
  };

  constructor(
    private gestionService: GestionService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {}

  openModal(content: any) {
    (this.usuarioActualizado.nombre = this.usuario.nombre),
      (this.usuarioActualizado.apellido = this.usuario.apellido),
      (this.usuarioActualizado.dni = this.usuario.dni),
      (this.usuarioActualizado.telefono = this.usuario.telefono),
      (this.usuarioActualizado.rol = this.usuario.rol),
      (this.usuarioActualizado.idUsuario = this.usuario.idUsuario),
      (this.usuarioActualizado.password = this.usuario.contraseña),
      (this.usuarioActualizado.fechaNacimiento = this.usuario.fechaNacimiento),
      (this.usuarioActualizado.nombreUsuario = this.usuario.nombreUsuario);
    const modalRef = this.modalService.open(content, {
      backdropClass: "backdrop",
      size: "lg",
      centered: true,
    });
  }

  modificarUsuario() {
    this.gestionService
      .actualizarUsuario(this.usuario.idUsuario || 0, this.usuarioActualizado)
      .subscribe(
        (res) => {
          this.getAllUsuarios();
        },
        (e) => {
          console.log(e);
        }
      );
  }
}
