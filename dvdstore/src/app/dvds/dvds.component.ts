import { Component,OnInit } from '@angular/core';
import { DvdsService } from '../services/dvds.service';



@Component({
  selector: 'app-dvds',
  templateUrl: './dvds.component.html',
  styleUrls: ['./dvds.component.css']
})
export class DvdsComponent implements OnInit {

  dvds:any

  constructor(private dvdsService: DvdsService) { }


  ngOnInit() {
    this.dvdsService.getAll().subscribe(data => {
      console.log("Recuperando la data :", data);

      // Normalizar las URLs en la propiedad image_path sin sanitizer
      this.dvds = data.map((dvd: any) => ({
        ...dvd,
        imagePath: dvd.imagePath ? dvd.imagePath.replace(/\\/g, '/') : undefined
      }));

      console.log("Recuperando la data después de replace:", this.dvds);

    });
  }
}