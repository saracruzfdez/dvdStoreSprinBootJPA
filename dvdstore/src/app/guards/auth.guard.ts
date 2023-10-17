import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authenticationService: AuthenticationService, private router: Router) {}

  canActivate(): boolean {
    if (this.authenticationService.isAuthenticated()) {
      return true; // Permite el acceso a la ruta si el usuario está autenticado
    } else {
      this.router.navigate(['/login']); // Redirige a la página de inicio de sesión si el usuario no está autenticado
      return false;
    }
  }
}
