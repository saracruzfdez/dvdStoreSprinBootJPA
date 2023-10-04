import { Component, OnInit } from '@angular/core';
import { ClientsService } from '../services/clients.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: any;

  constructor(private clientsService: ClientsService) { }

  ngOnInit(): void {
    this.clientsService.getAll().subscribe(data => {
      console.log("Recuperando la data", data);

      this.clients = data;
      console.log(this.clients)
    })
  }
}