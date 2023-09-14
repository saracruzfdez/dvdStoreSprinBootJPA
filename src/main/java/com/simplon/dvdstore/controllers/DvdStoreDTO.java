package com.simplon.dvdstore.controllers;

import lombok.Data;
import lombok.Value;

@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@Value // Hace que la clase sea inmutable.
public class DvdStoreDTO {
    private String name;  // Nombre del DVD.
    private String genre; // Género del DVD.
}