import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { DvdsComponent } from './dvds/dvds.component';
import { DvdsMenuComponent } from './dvds/dvds-menu/dvds-menu.component';
import { DvdsTitleComponent } from './dvds/dvds-title/dvds-title.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    DvdsComponent,
    DvdsMenuComponent,
    DvdsTitleComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
