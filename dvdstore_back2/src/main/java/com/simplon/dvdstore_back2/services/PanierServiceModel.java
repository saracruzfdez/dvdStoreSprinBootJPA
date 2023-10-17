package com.simplon.dvdstore_back2.services;

import lombok.*;

@Data
@AllArgsConstructor
public class PanierServiceModel {
    private int vente_id;
    private int client_id;
    private int dvd_id;
    private float dvd_price;
    private int dvd_quantity;

    // POST
    public PanierServiceModel(Integer vente_id, Integer client_id, Integer dvd_id, Float dvd_price, Integer dvd_quantity) {
        this.vente_id = vente_id;
        this.client_id = client_id;
        this.dvd_id = dvd_id;
        this.dvd_price = dvd_price;
        this.dvd_quantity = dvd_quantity;
    }
}