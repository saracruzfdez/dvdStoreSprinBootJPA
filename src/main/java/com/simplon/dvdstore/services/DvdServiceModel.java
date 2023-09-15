package com.simplon.dvdstore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DvdServiceModel {
    private String name;
    private String genre;
    private Integer quantity;

}