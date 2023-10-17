package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class DvdServiceModel {
    private Optional<Long> id;
    private String name;
    private String genre;
    private Integer quantity;
    private Float prix;
    private String imagePath;

    //POST
    public DvdServiceModel(String name, String genre, Float prix, Integer quantity, String imagePath) {
        this.name = name;
        this.genre = genre;
        this.prix = prix;
        this.quantity = quantity;
        this.imagePath=imagePath;
    }

    //GETS
    public DvdServiceModel(Optional<Long> id, String name, String genre, Integer quantity, Float prix, String imagePath) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.prix = prix;
        this.imagePath=imagePath;

    }
}

