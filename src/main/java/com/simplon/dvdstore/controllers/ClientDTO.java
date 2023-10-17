package com.simplon.dvdstore.controllers;

import lombok.Data;
import lombok.Value;

@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@Value // Hace que la clase sea inmutable.
public class ClientDTO {
    private String name;
    private String email;
}

