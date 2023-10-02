import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { DvdsComponent } from './dvds/dvds.component';
import { DvdsMenuComponent } from './dvds/dvds-menu/dvds-menu.component';
import { DvdsTitleComponent } from './dvds/dvds-title/dvds-title.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { HomeTitleComponent } from './home/home-title/home-title.component';
import { DvdComponent } from './dvd/dvd.component';
import { DvdMenuComponent } from './dvd/dvd-menu/dvd-menu.component';
import { DvdFormComponent } from './dvd-form/dvd-form.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    DvdsComponent,
    DvdsMenuComponent,
    DvdsTitleComponent,
    HomeComponent,
    HomeTitleComponent,
    DvdComponent,
    DvdMenuComponent,
    DvdFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
