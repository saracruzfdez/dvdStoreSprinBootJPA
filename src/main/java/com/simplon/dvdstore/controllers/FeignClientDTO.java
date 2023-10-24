package com.simplon.dvdstore.controllers;

import lombok.Data;

@Data
public class FeignClientDTO {
    private int client_id;
    private int dvd_id;
    private float dvd_price;
    private int dvd_quantity;

}
