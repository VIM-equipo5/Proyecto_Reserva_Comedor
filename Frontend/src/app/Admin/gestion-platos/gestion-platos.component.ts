import { Component, OnInit } from '@angular/core';
import { isConstructorDeclaration } from 'typescript';

@Component({
  selector: 'app-gestion-platos',
  templateUrl: './gestion-platos.component.html',
  styleUrls: ['./gestion-platos.component.css']
})
export class GestionPlatosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  crearPlato(): void {
    console.log("Hola, te hago tus platos");
  }
}
