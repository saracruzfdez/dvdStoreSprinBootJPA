package com.simplon.dvdstore.controllers;

public record VenteGetDTO (Long id, ClientDTO client, DvdDTO dvd, int quantity, float total) {}
