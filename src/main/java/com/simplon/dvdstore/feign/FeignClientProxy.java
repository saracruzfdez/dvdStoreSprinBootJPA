package com.simplon.dvdstore.feign;

import com.simplon.dvdstore.controllers.FeignClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// pas besoin de passer par un service, on pourrait même supprimer le controller pour le feign et l'implementer dans un de nos controllers déjà en place
@FeignClient(name = "panier-service", url = "http://localhost:90")
public interface FeignClientProxy {

    @PostMapping("/paniers")
    boolean addPanierToPgBdd(@RequestBody FeignClientDTO feignClientDTO);

    @GetMapping("/paniers")
    List<FeignClientDTO> getAllPaniers(); // from back2

    @GetMapping("/paniers/{panierId}")
    FeignClientDTO getPanierById(@PathVariable Long panierId);
}

