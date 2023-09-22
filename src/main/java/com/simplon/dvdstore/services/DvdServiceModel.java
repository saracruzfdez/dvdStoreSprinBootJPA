package com.simplon.dvdstore.services;

import jakarta.persistence.Entity;
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

    public DvdServiceModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}

