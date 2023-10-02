import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Dvd, DvdsService } from '../services/dvds.service';

@Component({
  selector: 'app-dvd-form',
  templateUrl: './dvd-form.component.html',
  styleUrls: ['./dvd-form.component.css']
})
export class DvdFormComponent {

  constructor(private dvdService: DvdsService, private router: Router, private route: ActivatedRoute) { }

  dvd: Dvd = {
    id: 0,
    name: '',
    genre: '',
    prix: 0,
    quantity: 0,
    image_path: ''
  }

  isUpdate: boolean = false;

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      // Si hay un ID en la URL, estás en modo de actualización
      this.isUpdate = true;
      // Llama a tu servicio para obtener los detalles del DVD por ID y actualiza this.dvd
      this.dvdService.getById(Number(id)).subscribe((dvd) => {
       
        this.dvd = dvd;
      });
    }
  }

  formulaire(form: NgForm) {
    console.log(form.value)

    if (form.valid) {
      if (this.isUpdate) {
        // Estás en modo de actualización, llama a actualizar
        this.dvdService.addOrUpdate(this.dvd).subscribe(() => {


                console.log('El campo de imagen está vacío en el modo de creación.');

          // Lógica adicional después de la actualización
          this.router.navigate(['/dvds']); // Por ejemplo, redirige a la lista de DVDs
        });
      } else {
        // Estás en modo de creación, llama a agregar
        this.dvdService.addOrUpdate(this.dvd).subscribe(() => {
          // Lógica adicional después de la creación
          this.router.navigate(['/dvds']); // Por ejemplo, redirige a la lista de DVDs
        });
      }
    }
  }
}
