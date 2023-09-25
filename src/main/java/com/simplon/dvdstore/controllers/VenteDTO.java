package com.simplon.dvdstore.controllers;

import java.util.Date;

public record VenteDTO(Long client_id, Long dvd_id, int quantity, float total) {
}

