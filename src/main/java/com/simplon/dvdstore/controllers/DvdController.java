package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("dvds")
public class DvdController {
    @Autowired
    DvdService dvdService;

    @PostMapping
    public boolean addDvdToStore(@RequestBody DvdDTO dvdDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdDTO.getName(), dvdDTO.getGenre(), dvdDTO.getQuantity(), dvdDTO.getPrix());
        return dvdService.add(dvdServiceModel);
    }

    @GetMapping
    public ArrayList<DvdDTO> getAll() {
        ArrayList<DvdDTO> dvdDTOS = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModelArrayList = dvdService.getAll();
        for (DvdServiceModel x : dvdServiceModelArrayList) {
            dvdDTOS.add(new DvdDTO(x.getName(), x.getGenre(), x.getQuantity(), x.getPrix()));
        }
        return dvdDTOS;
    }

    @GetMapping("/{id}")
    public DvdDTO getById(@PathVariable Long id) {
        DvdServiceModel dvdServiceModel = dvdService.getById(id);
        return new DvdDTO(dvdServiceModel.getName(), dvdServiceModel.getGenre(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrix());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        dvdService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody DvdDTO dvdDTO) {

        return dvdService.update(id, new DvdServiceModel(dvdDTO.getName(), dvdDTO.getGenre(), dvdDTO.getQuantity(), dvdDTO.getPrix()));
    }
}