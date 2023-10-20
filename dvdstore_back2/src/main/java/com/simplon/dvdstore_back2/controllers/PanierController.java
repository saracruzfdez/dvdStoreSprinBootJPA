package com.simplon.dvdstore_back2.controllers;

import com.simplon.dvdstore_back2.mappers.PanierMapper;
import com.simplon.dvdstore_back2.services.PanierService;
import com.simplon.dvdstore_back2.services.PanierServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<PanierDTO> getAllPaniers() {
        List<PanierServiceModel> panierServiceModels = panierService.getAllPaniers();
        return panierServiceModels.stream()
                .map(panierMapper::panierServiceModelToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{panierId}")
    public ResponseEntity<PanierDTO> getPanierById(@PathVariable Long panierId) {
        PanierServiceModel panierServiceModel = panierService.getPanierById(panierId);
        if (panierServiceModel != null) {
            PanierDTO panierDTO = panierMapper.panierServiceModelToDTO(panierServiceModel);
            return ResponseEntity.ok(panierDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{panierId}")
    public ResponseEntity<String> updatePanier(@PathVariable Long panierId, @RequestBody PanierDTO updatedPanierDTO) {
        PanierServiceModel updatedPanierServiceModel = panierMapper.dtoToServiceModel(updatedPanierDTO);
        if(panierService.updatePanier(panierId, updatedPanierServiceModel)){
            return ResponseEntity.ok("Ton panier a été mis a jour avec succes !");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{panierId}")
    public ResponseEntity<String> deletePanier(@PathVariable Long panierId){
        if(panierService.deletePanier(panierId)){
            return ResponseEntity.ok("Registro eliminado exitosamente");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /* SANS MAPSTRUCT
    @PostMapping
    public boolean addPanierToPgBdd(@RequestBody PanierDTO panierDTO) {
        PanierServiceModel panierServiceModel = new PanierServiceModel(panierDTO.vente_id(), panierDTO.client_id(), panierDTO.dvd_id(), panierDTO.dvd_price(), panierDTO.dvd_quantity());
        return panierService.add(panierServiceModel);
    } */
}