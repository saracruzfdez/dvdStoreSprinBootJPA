package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DvdServiceModel {
    private String name;
    private String genre;
    private Integer quantity;
    private Float prix;

    public DvdServiceModel(String name, String genre, Float prix, Integer quantity) {
        this.name = name;
        this.genre = genre;
        this.prix = prix;
        this.quantity = quantity;
    }
}

