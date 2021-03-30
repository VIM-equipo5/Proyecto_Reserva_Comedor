import { Component, Input, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";




/* services */
import { LoginService } from "../service/login.service";

/* models */
import { Usuario } from "src/app/model/Usuarios";


@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  usuario: Usuario = new Usuario();
  registro = new FormGroup({
    nombreUsuario: new FormControl("", Validators.required),
    contraseña: new FormControl("", Validators.required),
    nombre: new FormControl("", Validators.required),
    apellido: new FormControl("", Validators.required),
    dni: new FormControl("", Validators.required),
    telefono: new FormControl("", Validators.required),
    fechaNacimiento: new FormControl("", Validators.required),
  });

  constructor(
    private loginService: LoginService,
    private router: Router,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.registrarUsuario();
  }

  registrarUsuario() {
    let body = `{ "rol": {"idRol": 2,"nombreRol": "usuario","descripcion": "Usuario llano, con autorizacion solo para realizar reservas"},`;
    Object.keys(this.registro.controls).forEach((key) => {
      body += `"${key}":"${this.registro.controls[key].value}",`;
    });
    body = JSON.stringify(`${body.slice(0, -1)} }`);

    this.loginService.createUsuario(body).subscribe(
      (data) => {
        /* No hacemos nada con la respuesta */
        console.log(data);
        this.router.navigate(["/"]);
      },
      (error) => {
        this.open();
      }
    );
    
  }

  open() {
    const modalRef = this.modalService.open(NgbdModalContent, {
      centered: true,
    });
  }
}

@Component({
  selector: "ngbd-modal-content",
  template: `
    <div class="modal-header">
      <h4 class="modal-title">Error al crear usuario</h4>
      <button
        type="button"
        class="close"
        aria-label="Close"
        (click)="activeModal.dismiss('Cross click')"
      ></button>
    </div>
    <div class="modal-body">
      <p style="text-align=center">El nombre de usuario ya existe.</p>
    </div>
    <div class="modal-footer">
      <button
        type="button"
        class="btn btn btn-principal"
        (click)="activeModal.close('Close click')"
      >
        Cerrar
      </button>
    </div>
  `,
})
export class NgbdModalContent {
  @Input() name: any;

  constructor(public activeModal: NgbActiveModal) {}
}
