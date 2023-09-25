package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.VenteService;
import com.simplon.dvdstore.services.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("ventes")
public class VenteController {

    @Autowired
    VenteService venteService;

    @PostMapping
    public boolean addVenteToStore(@RequestBody VenteDTO venteDTO) {
        VenteServiceModel venteServiceModel = new VenteServiceModel(
                Optional.ofNullable(venteDTO.client_id()),
                Optional.ofNullable(venteDTO.dvd_id()),
                venteDTO.quantity(),
                venteDTO.total());
        return venteService.add(venteServiceModel);
    }

    @GetMapping
    public ArrayList<VenteGetDTO> getAll() {
        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();

        ArrayList<VenteServiceModel> venteServiceModelArrayList = venteService.getAll();

        for (VenteServiceModel x : venteServiceModelArrayList) {
            // mapper client service -> dto
            ClientDTO clientDTO = new ClientDTO(
                    x.getClient().get().getName(),
                    x.getClient().get().getEmail()
            );
            // mapper dvd service -> dto
            DvdDTO dvdDTO = new DvdDTO(
                    x.getDvd().get().getName(),
                    x.getDvd().get().getGenre(),
                    x.getDvd().get().getQuantity(),
                    x.getDvd().get().getPrix()
            );
            // Long id, ClientDTO clientDTO, DvdDTO dvdDTO, int quantity, float total
            venteGetDTOS.add(new VenteGetDTO(
                    x.getId().get(),
                    clientDTO,
                    dvdDTO,
                    x.getQuantity(),
                    x.getTotal(),
                    x.getDate()
            ));
        }

        return venteGetDTOS;
    }
}