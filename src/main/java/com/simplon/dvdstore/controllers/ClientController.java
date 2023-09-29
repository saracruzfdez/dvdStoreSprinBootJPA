package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientService;
import com.simplon.dvdstore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController // données JSON grace à REST ou XML
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public boolean addClientToStore(@RequestBody ClientDTO clientDTO) {
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.getName(), clientDTO.getEmail());

        return clientService.add(clientServiceModel);
    }

    @GetMapping
    public ArrayList<ClientGetDTO> getAll() {
        ArrayList<ClientGetDTO> clientGetDTOS = new ArrayList<>();
        ArrayList<ClientServiceModel> clientServiceModelArrayList = clientService.getAll();
        for (ClientServiceModel j : clientServiceModelArrayList) {
            clientGetDTOS.add(new ClientGetDTO(
                    Optional.of(j.getId().get()),
                    j.getName(),
                    j.getEmail()));
        }
        return clientGetDTOS;
    }

    @GetMapping("/{id}")
    public ClientGetDTO getById(@PathVariable Long id) {
        ClientServiceModel clientServiceModel = clientService.getById(id);
        return new ClientGetDTO(clientServiceModel.getId(), clientServiceModel.getName(), clientServiceModel.getEmail());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO) {
        return clientService.update(id, new ClientServiceModel(clientDTO.getName(), clientDTO.getEmail()));
    }
}