package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("dvds")
public class DvdController {
    @Autowired
    DvdService dvdService;

    @PostMapping
    public boolean addDvdToStore(@RequestBody DvdDTO dvdDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdDTO.getName(), dvdDTO.getGenre(), dvdDTO.getPrix(), dvdDTO.getQuantity());
        return dvdService.add(dvdServiceModel);
    }

    @GetMapping
    public ArrayList<DvdGetDTO> getAll() {
        ArrayList<DvdGetDTO> dvdGetDTOS = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModelArrayList = dvdService.getAll();
        for (DvdServiceModel x : dvdServiceModelArrayList) {
            dvdGetDTOS.add(new DvdGetDTO(
                    Optional.of(x.getId().get()),
                    x.getName(),
                    x.getGenre(),
                    x.getQuantity(),
                    x.getPrix()));
        }
        return dvdGetDTOS;
    }

    @GetMapping("/{id}")
    public DvdGetDTO getById(@PathVariable Long id) {
        DvdServiceModel dvdServiceModel = dvdService.getById(id);
        return new DvdGetDTO(dvdServiceModel.getId(), dvdServiceModel.getName(), dvdServiceModel.getGenre(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrix());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        dvdService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody DvdDTO dvdDTO) {

        return dvdService.update(id, new DvdServiceModel(dvdDTO.getName(), dvdDTO.getGenre(), dvdDTO.getPrix(), dvdDTO.getQuantity()));
    }
}