import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http'; // Importa HttpHeaders

import { AuthRequest, AuthenticationService } from '../services/authentication.service'

@Component({
  selector: 'app-login',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginComponent {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  authRequest: AuthRequest = {
    username: '',
    password: ''
  }

  send = (form: NgForm) => {
    console.log(form.value);

    this.authRequest.username = form.value.username;
    this.authRequest.password = form.value.password;

    this.authenticationService.authorize(this.authRequest).subscribe((data) => {
      console.log(data);
      // enregistre le token dans session storage
      this.authenticationService.setToken(data.token);
      // enregistre le token dans session storage
      this.authenticationService.setUser(data.user);


      const headers = new HttpHeaders({
        Authorization: `Bearer ${sessionStorage.getItem('token')}`
      });


       // Luego, puedes utilizar `headers` en tus solicitudes HTTP
      // Por ejemplo:
      // this.http.get('/api/ruta-protegida', { headers }).subscribe(response => {
      //   // Maneja la respuesta
      // });

      
      this.router.navigate(['/dvds'])
    });
  }
}