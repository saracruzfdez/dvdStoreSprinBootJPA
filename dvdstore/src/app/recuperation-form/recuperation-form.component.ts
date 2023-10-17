import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recuperation-form',
  templateUrl: './recuperation-form.component.html',
  styleUrls: ['./recuperation-form.component.css']
})
export class RecuperationFormComponent {

  // Variable para rastrear si se ha presionado el botón "Ok"
  isOkButtonPressed: boolean = false;

  constructor(private router: Router) { }

  send = (form: NgForm) => {
    console.log(form.value);

    this.isOkButtonPressed = true;
  }

  // Función para redirigir después de presionar el botón "Ok"
  redirectToPage() {

    if (this.isOkButtonPressed) {
      // Redirige a la página deseada
      this.router.navigate(['/login-form']);
    }
  }



}
