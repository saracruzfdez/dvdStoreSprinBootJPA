package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.VenteService;
import com.simplon.dvdstore.services.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping
    public ArrayList<VenteDTO> getAll(){
        ArrayList<VenteDTO> venteDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModelArrayList = venteService.getAll();
        for (VenteServiceModel x : venteServiceModelArrayList){
            venteDTOS.add(new VenteDTO(x.getClient_id(), x.getDvd_id(), x.getQuantity(), x.getTotal()));
        }
        return venteDTOS;

    }

}
