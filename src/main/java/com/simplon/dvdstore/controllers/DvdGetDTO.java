package com.simplon.dvdstore.controllers;

import lombok.Data;
import lombok.Value;

import java.util.Optional;

@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@Value // Hace que la clase sea inmutable.
public class DvdGetDTO {
    private Optional<Long> id;
    private String name;  // Nombre del DVD.
    private String genre; // Género del DVD.
    private Integer quantity;
    private Float prix;

    public DvdGetDTO(Optional<Long> id, String name, String genre, Integer quantity, Float prix) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.prix = prix;
    }
}