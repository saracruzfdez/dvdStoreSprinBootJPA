import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit{;

  constructor(protected authentication: AuthenticationService){}

  //isLoggedIn:boolean = false;
  

ngOnInit(): void {
  //this.isLoggedIn = this.authentication.is_auth();
}
deconnexion = () => {
  this.authentication.logout();
 }

}
