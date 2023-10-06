import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthRequest, AthenticationService } from '../services/athentication.service'

@Component({
  selector: 'app-login',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginComponent {

  constructor(private authenticationService: AthenticationService, private router: Router, private route: ActivatedRoute) { }

  authRequest: AuthRequest = {
    username: '',
    password: ''
  }

  send = (form: NgForm) => {
    console.log(form.value);

    this.authRequest.username = form.value.username;
    this.authRequest.password = form.value.password;

    this.authenticationService.authorize(this.authRequest).subscribe(() => {

    });
  }
}