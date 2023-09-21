package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientService;
import com.simplon.dvdstore.services.ClientServiceModel;
import com.simplon.dvdstore.services.DvdServiceModel;
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

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable Long id) {
        ClientServiceModel clientServiceModel = clientService.getById(id);
        return new ClientDTO(clientServiceModel.getName(), clientServiceModel.getEmail());
    }

@DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){clientService.deleteById(id);}

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO){
        return  clientService.update(id, new ClientServiceModel(clientDTO.getName(), clientDTO.getEmail()));
    }

















}


