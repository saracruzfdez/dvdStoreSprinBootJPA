import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DvdsComponent } from './dvds/dvds.component';

const routes: Routes = [
  { path: '', component : DvdsComponent},
  { path: 'dvds', component : DvdsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
