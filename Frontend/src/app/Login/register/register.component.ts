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
  usuario: Usuario;

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
  ) {
    this.usuario = new Usuario();
  }

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
        this.open("¡Exito!",'Usuario creado con exito');
        this.router.navigate(["/"]);
      },
      (e) => {
        console.log(e)
        let titulo = "Error al crear usuario";
        let errorMsg = "";
        
        switch(e.error.status){
          case 400:
            if(e.error.message.indexOf('Cannot deserialize value of type `int`') >= 0)
              errorMsg = "El teléfono de contacto solo pueden ser dígitos";
            else if(e.error.message.indexOf('JSON parse error: Cannot deserialize value of type `java.util.Date`') >= 0)
              errorMsg = "Debe introducir una fecha válida";
            break;
          case 500:
            if(this.registro.controls['dni'].value.length > 9 )
              errorMsg = "DNI debe estar formado por ocho dígitos y un carácter alfabético de control";
            if(e.error.message.indexOf('could not execute statement; SQL [n/a]; constraint [usuario.NombreUsuario];') >= 0)
              errorMsg = "El nombre de usuario ya existe. Introduzca uno diferente"
            if(e.error.message.indexOf('could not execute statement; SQL [n/a]; constraint [usuario.DNI];') >= 0)
              errorMsg = "El DNI ya existe."
            break;
          default:
            errorMsg = "Ha ocurrido un error inesperado, vuelva a intentarlo.";
            break;
        }
        
        this.open(titulo,errorMsg);
      }
    );
  }
  
  open(titulo: String,errorMsg: String) {
    const modalRef = this.modalService.open(NgbdModalContent, {
      centered: true,
    });
    modalRef.componentInstance.titulo = titulo;
    modalRef.componentInstance.msg = errorMsg;
  }
}

@Component({
  selector: "ngbd-modal-content",
  template: `
    <div class="modal-header">
      <h4 class="modal-title">{{titulo}}</h4>
      <button
        type="button"
        class="close"
        aria-label="Close"
        (click)="activeModal.dismiss('Cross click')"
      ></button>
    </div>
    <div class="modal-body">
      <p style="text-align=center">{{msg}}</p>
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
  @Input() titulo!: String;
  @Input() msg!: String;

  constructor(public activeModal: NgbActiveModal) {}
}
