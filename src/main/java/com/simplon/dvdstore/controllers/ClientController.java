package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientService;
import com.simplon.dvdstore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The type Client controller.
 */
@RestController // données JSON grace à REST ou XML
@CrossOrigin("*")
@RequestMapping("/clients")
// @PreAuthorize("isAuthenticated()")
public class ClientController {

    /**
     * The Client service.
     */
    @Autowired
    ClientService clientService;

    /**
     * Add client to store boolean.
     *
     * @param clientDTO the client dto
     * @return the boolean
     */
    @PostMapping("/private")
    public boolean addClientToStore(@RequestBody ClientDTO clientDTO) {
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.getName(), clientDTO.getEmail());

        return clientService.add(clientServiceModel);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/private")
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

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/private/{id}")
    public ClientGetDTO getById(@PathVariable Long id) {
        ClientServiceModel clientServiceModel = clientService.getById(id);
        return new ClientGetDTO(clientServiceModel.getId(), clientServiceModel.getName(), clientServiceModel.getEmail());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping("/private/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    /**
     * Update boolean.
     *
     * @param id        the id
     * @param clientDTO the client dto
     * @return the boolean
     */
    @PutMapping("/private/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO) {
        return clientService.update(id, new ClientServiceModel(clientDTO.getName(), clientDTO.getEmail()));
    }
}