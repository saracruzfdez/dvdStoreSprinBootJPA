package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.VenteService;
import com.simplon.dvdstore.services.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ventes")
public class VenteController {

    @Autowired
    VenteService venteService;

    @PostMapping
    public boolean addVenteToStore(@RequestBody VenteDTO venteDTO){
        VenteServiceModel venteServiceModel = new VenteServiceModel( venteDTO.client_id(), venteDTO.dvd_id(),venteDTO.quantity(), venteDTO.total());
        return venteService.add(venteServiceModel);
    }

}
