package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
public class VenteServiceModel {
    private Optional<Long> id;
    private Optional<Long> client_id;
    private Optional<Long> dvd_id;
    private int quantity;
    private float total;
    private Optional<DvdServiceModel> dvd;
    private Optional<ClientServiceModel> client;
    private LocalDate localDate;

    // POST
    public VenteServiceModel(Optional<Long> client_id, Optional<Long> dvd_id, int quantity, float total, LocalDate localDate) {
        this.client_id = client_id;
        this.dvd_id = dvd_id;
        this.quantity = quantity;
        this.total = total;
        this.localDate = localDate;
    }

    // GETS
    public VenteServiceModel(Optional<Long> id, int quantity, Float total, Optional<DvdServiceModel> dvd, Optional<ClientServiceModel> client, LocalDate localDate) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.dvd = dvd;
        this.client = client;
        this.localDate = localDate;
    }
}