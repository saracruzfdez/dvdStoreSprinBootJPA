import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

import { DvdsComponent } from './dvds/dvds.component';
import { DvdComponent } from './dvd/dvd.component';
import { DvdFormComponent } from './dvd-form/dvd-form.component';

import { ClientsComponent } from './clients/clients.component';
import { ClientComponent } from './client/client.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },

  { path: 'dvds', component: DvdsComponent },
  { path: 'dvd/:id', component: DvdComponent },
  { path: 'dvd-form', component: DvdFormComponent },
  { path: 'dvd-form/:id', component: DvdFormComponent },

  { path: 'clients', component: ClientsComponent },
  { path: 'client/:id', component: ClientComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
