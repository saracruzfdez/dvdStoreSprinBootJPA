package com.simplon.dvdstore.controllers;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class DvdStoreDTO {
    private String name;
    private String genre;
}

// a tester également avec : public record DvdStoreDTO(String name, String genre) {
//}