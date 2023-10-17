import { Component, OnInit } from '@angular/core';
import { ClientsService } from '../services/clients.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})

export class ClientComponent implements OnInit {

  id: any;
  client: any;

  constructor(private clientsService: ClientsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');

    this.clientsService.getById(this.id).subscribe((clientData) => {
      console.log(clientData);
      this.client = clientData;
    })
  }
}