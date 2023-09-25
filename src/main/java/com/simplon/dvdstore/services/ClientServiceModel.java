package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
public class ClientServiceModel {
    private Optional<Long> id;
    private String name;
    private String email;

    //POST
    public ClientServiceModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //GETS
    public ClientServiceModel(Optional<Long> id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

