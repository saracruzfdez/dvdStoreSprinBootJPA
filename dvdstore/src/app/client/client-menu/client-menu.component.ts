import { Component, OnInit } from '@angular/core';
import { ClientsService } from '../../services/clients.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-client-menu',
  templateUrl: './client-menu.component.html',
  styleUrls: ['./client-menu.component.css']
})
export class ClientMenuComponent implements OnInit {

  id: any;
  client: any;

  constructor(private clientsService: ClientsService, private route: ActivatedRoute) {}
  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    console.log(this.id)
    
   this.clientsService.getById(this.id).subscribe((clientData)=>{
    this.client=clientData;
   })
    
    
    }
}
