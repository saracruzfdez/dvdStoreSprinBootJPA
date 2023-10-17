package com.simplon.dvdstore_back2.controllers;

import com.simplon.dvdstore_back2.services.PanierService;
import com.simplon.dvdstore_back2.services.PanierServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // données JSON grace à REST ou XML
@CrossOrigin("*")
@RequestMapping("paniers")
public class PanierController {

    @Autowired
    PanierService panierService;

    @PostMapping
    public boolean addPanierToPgBdd(@RequestBody PanierDTO panierDTO){
        PanierServiceModel panierServiceModel = new PanierServiceModel(panierDTO.vente_id(), panierDTO.client_id(), panierDTO.dvd_id(), panierDTO.dvd_price(), panierDTO.dvd_quantity());

return panierService.add(panierServiceModel);
    }
}
