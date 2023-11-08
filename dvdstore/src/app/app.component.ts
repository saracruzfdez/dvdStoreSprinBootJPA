import { Component } from '@angular/core';
import { Platform } from '@ionic/angular'; // Importa Platform

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'dvdstore';

  isDesktopPlatform: boolean =false;
  isMobile: boolean = false;

  constructor(private platform: Platform) {
    // if(this.platform.is('android') || this.platform.is('ios')) {
    //   this.isDesktopPlatform = false;
    //   this.isMobile = true;
    // } else {
    //   this.isDesktopPlatform = true;
    //   this.isMobile = false;
    // }
    // this.isMobile = this.platform.is('android') || this.platform.is('ios');
    
  }

  ngOnInit(): void {
    if(this.platform.is('android') || this.platform.is('ios')) {
      this.isDesktopPlatform = false;
      this.isMobile = true;
    } else {
      this.isDesktopPlatform = true;
      this.isMobile = false;
    }

    console.log("isDesktopPlatform", this.isDesktopPlatform)
    console.log("isMobile", this.isMobile)
  }
}