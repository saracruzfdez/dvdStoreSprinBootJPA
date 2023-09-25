package com.simplon.dvdstore.controllers;

import lombok.Data;
import lombok.Value;

import java.util.Optional;

@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@Value // Hace que la clase sea inmutable.
public class ClientGetDTO {
    private Optional<Long> id;
    private String name;
    private String email;

    public ClientGetDTO(Optional<Long> id, String name, String email) {
        this.id=id;
        this.name=name;
        this.email=email;
    }
}

