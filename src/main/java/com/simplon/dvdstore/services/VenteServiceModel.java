package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteServiceModel {
   private Optional<Long> id;
   private Optional<Long> client_id;
   private Optional<Long> dvd_id;
   private int quantity;
   private float total;
   private Optional<DvdServiceModel> dvd;
   private Optional<ClientServiceModel> client;

   // POST
    public VenteServiceModel(Optional<Long> client_id, Optional<Long> dvd_id, int quantity, float total) {
        this.client_id = client_id;
        this.dvd_id = dvd_id;
        this.quantity = quantity;
        this.total = total;
    }

    // GETS
    public VenteServiceModel(Optional<Long> id, int quantity, Float total, Optional<DvdServiceModel> dvd, Optional<ClientServiceModel> client) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.dvd = dvd;
        this.client = client;
    }
}
