import { Component, Input, OnInit } from "@angular/core";
import { FormArray, FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { NgbActiveModal, NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { LoginService } from "../login.service";
import { Usuario } from "../usuario/model/usuarios";
import { Rol } from "../usuario/model/rol";
import { NgxSpinnerService } from "ngx-spinner";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  constructor(
    private loginService: LoginService,
    private router: Router,
    private modalService: NgbModal,
    private spinner: NgxSpinnerService
  ) {}

  login = new FormGroup({
    username: new FormControl("", Validators.required),
    password: new FormControl("", Validators.required),
  });

  usuario = new Usuario();

  ngOnInit(): void {}

  onSubmit() {
    this.autentificar();
  }

  autentificar() {
    const user = this.login.get("username") as FormArray,
      password = this.login.get("password") as FormArray;
    /* Si ambos campos son validos, buscamos credenciales */
    if (!user.invalid && !password.invalid) {
      this.spinner.show();
      this.getUsuario(user.value).subscribe((res: any) => {
        try {
          this.usuario.idUsuario = res[0].idUsuario;
          this.usuario.nombreUsuario = res[0].nombreUsuario;
          this.usuario.password = res[0].contraseña;
          this.usuario.nombre = res[0].nombre;
          this.usuario.apellido = res[0].apellido;
          this.usuario.dni = res[0].dni;
          this.usuario.fechaNacimiento = res[0].fechaNacimiento;
          this.usuario.telefono = res[0].telefono;
          this.usuario.rol = new Rol();
          this.usuario.rol.idRol = res[0].rol.idRol;
          this.usuario.rol.nombreRol = res[0].rol.nombreRol;
          this.usuario.rol.descripcion = res[0].rol.descripcion;
        } catch (error) {
          this.spinner.hide();
        }

        this.spinner.hide();
        /* Verificación de las credenciales del usuario */
        if (
          this.usuario.nombreUsuario === user.value &&
          this.usuario.password === password.value
        ) {
          window.sessionStorage.setItem("user", JSON.stringify(this.usuario));

          if (this.usuario.rol.idRol == 2) this.router.navigate(["/home"]);
          else this.router.navigate(["/admin"]);
        } else {
          $("#inputUsername").addClass("is-invalid");
          $("#inputPassword").addClass("is-invalid");
          password.setValue([""]);
          this.open();
        }
      });
    } else {
      /* Pintamos el campo vacio como necesario */
      $("#inputUsername").addClass("is-invalid");
      $("#inputPassword").addClass("is-invalid");
    }
  }

  getUsuario(username: String) {
    /* Todas las peticiones estan abiertas. */
    return this.loginService.getUsuario(username);
  }

  open() {
    const modalRef = this.modalService.open(NgbdModalContent, {
      centered: true,
    });
  }

  goToRegister() {
    this.spinner.show();
    this.router.navigate(["/logup"]);
  }
}

@Component({
  selector: "ngbd-modal-content",
  template: `
    <div class="modal-header">
      <h4 class="modal-title">Error en las crednciales</h4>
      <button
        type="button"
        class="close"
        aria-label="Close"
        (click)="activeModal.dismiss('Cross click')"
      ></button>
    </div>
    <div class="modal-body">
      <p style="text-align=center">
        El usuario o la contraseña no son correctos.
      </p>
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
function sleep(arg0: number) {
  throw new Error("Function not implemented.");
}
