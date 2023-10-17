package com.simplon.dvdstore.controllers;

import java.time.LocalDate;

public record VenteGetDTO (Long id, ClientDTO client, DvdDTO dvd, int quantity, float total, LocalDate localDate) {}
