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
   private Long client_id;
   private Long dvd_id;
   private int quantity;
   private float total;

    public VenteServiceModel(Long client_id, Long dvd_id, int quantity, float total) {
        this.client_id = client_id;
        this.dvd_id = dvd_id;
        this.quantity = quantity;
        this.total = total;
    }

}
