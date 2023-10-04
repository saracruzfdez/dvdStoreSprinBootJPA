import { Component, OnInit } from '@angular/core';
import { DvdsService } from '../services/dvds.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';


@Component({
  selector: 'app-dvd',
  templateUrl: './dvd.component.html',
  styleUrls: ['./dvd.component.css']
})
export class DvdComponent implements OnInit {

  id: any;
  dvd: any;

  constructor(private dvdsService: DvdsService, private route: ActivatedRoute, private router: Router) {}

  delete(id: any){

    this.dvdsService.deleteById(this.id).subscribe(()=>{
      this.router.navigate(['/dvds']);
    },
    (error)=>{
      console.error("Error al eliminar el dvd", error)
    })

  }

  ngOnInit() {
    
    this.id = this.route.snapshot.paramMap.get('id');
    console.log(this.id)
  
    // Cargar los detalles del DVD específico por su id
    this.dvdsService.getById(this.id).subscribe((dvdData) => {
      // Verificar si imagePath es una cadena antes de realizar el reemplazo
      if (typeof dvdData.image_path === 'string') {
        dvdData.image_path = dvdData.image_path.replace(/\\/g, '/');
      }
      this.dvd = dvdData;
      console.log("Detalles del DVD:", this.dvd);
    });
  }

}



    
  

