package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.feign.FeignClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/paniers")
public class FeignClientController {

    private final FeignClientProxy feignClientProxy;

    @Autowired
    public FeignClientController(FeignClientProxy feignClientProxy) {
        this.feignClientProxy = feignClientProxy;
    }

    @PostMapping
    public boolean addPanierToPgBdd(@RequestBody FeignClientDTO feignClientDTO){
        return feignClientProxy.addPanierToPgBdd(feignClientDTO);
    }

    @GetMapping
    public List<FeignClientDTO> getAllPaniers() {
        List<FeignClientDTO> feignClientDTOS = feignClientProxy.getAllPaniers();
        return feignClientDTOS;
    }

    @GetMapping("/{panierId}")
    public ResponseEntity<FeignClientDTO> getPanierById(@PathVariable Long panierId) {
FeignClientDTO panier = feignClientProxy.getPanierById(panierId);
        if (panier != null) {
            // Si se encontró el recurso, devuélvelo con un código de estado 200 (OK)
            return ResponseEntity.ok(panier);
        } else {
            // Si no se encontró el recurso, devuelve un código de estado 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}