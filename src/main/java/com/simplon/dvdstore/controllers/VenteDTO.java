package com.simplon.dvdstore.controllers;

import java.time.LocalDate;

public record VenteDTO(Long client_id, Long dvd_id, int quantity, float total, LocalDate localDate) {
}

