package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientService;
import com.simplon.dvdstore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController // données JSON grace à REST ou XML
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public boolean addClientToStore(@RequestBody ClientDTO clientDTO){
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.getName(), clientDTO.getEmail());

        return clientService.add(clientServiceModel);
    }

    @GetMapping
    public ArrayList<ClientDTO> getAll(){
        ArrayList<ClientDTO> clientDTOS=new ArrayList<>();
        ArrayList<ClientServiceModel> clientServiceModelArrayList = clientService.getAll();
        for (ClientServiceModel j : clientServiceModelArrayList) {
            clientDTOS.add(new ClientDTO(j.getName(), j.getEmail()));
        }
        return clientDTOS;
    }

}


