package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdModelService;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dvds")
public class DvsStoreController {
    @Autowired
    DvdStoreService dvdStoreService;

    @PostMapping
    public boolean addDvdToStore(@RequestBody DvdStoreDTO dvdStoreDTO) {
        DvdModelService dvdModelService = new DvdModelService(dvdStoreDTO.getName(), dvdStoreDTO.getGenre());
        return dvdStoreService.add(dvdModelService);
    }
}
