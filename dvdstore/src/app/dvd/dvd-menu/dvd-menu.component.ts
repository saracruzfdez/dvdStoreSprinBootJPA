import { Component, OnInit } from '@angular/core';
import { DvdsService } from '../../services/dvds.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dvd-menu',
  templateUrl: './dvd-menu.component.html',
  styleUrls: ['./dvd-menu.component.css']
})
export class DvdMenuComponent implements OnInit {

  id: any;
  dvd: any;

  constructor(private dvdsService: DvdsService, private route: ActivatedRoute) {}


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



    
  


