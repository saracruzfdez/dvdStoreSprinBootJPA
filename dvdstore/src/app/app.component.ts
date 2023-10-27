import { Component } from '@angular/core';
import { Platform } from '@ionic/angular'; // Importa Platform

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'dvdstore';

  isDesktopPlatform: boolean;
  isMobile: boolean

  constructor(private platform: Platform) {
    this.isDesktopPlatform = this.platform.is('desktop');
    this.isMobile = this.platform.is('android') || this.platform.is('ios');
  }
  
}