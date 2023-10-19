package com.simplon.dvdstore_back2.controllers;

import com.simplon.dvdstore_back2.mappers.PanierMapper;
import com.simplon.dvdstore_back2.services.PanierService;
import com.simplon.dvdstore_back2.services.PanierServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // données JSON grace à REST ou XML
@CrossOrigin("*")
@RequestMapping("/paniers")
public class PanierController {
    private final PanierService panierService;
    private final PanierMapper panierMapper;

    @Autowired
    public PanierController(PanierService panierService, PanierMapper panierMapper) {
        this.panierService = panierService;
        this.panierMapper = panierMapper;
    }

    @PostMapping
    public boolean addPanierToPgBdd(@RequestBody PanierDTO panierDTO) {
        PanierServiceModel panierServiceModel = panierMapper.dtoToServiceModel(panierDTO);
        return panierService.add(panierServiceModel);
    }

    /* SANS MAPSTRUCT
    @PostMapping
    public boolean addPanierToPgBdd(@RequestBody PanierDTO panierDTO) {
        PanierServiceModel panierServiceModel = new PanierServiceModel(panierDTO.vente_id(), panierDTO.client_id(), panierDTO.dvd_id(), panierDTO.dvd_price(), panierDTO.dvd_quantity());
        return panierService.add(panierServiceModel);
    }
    */
}