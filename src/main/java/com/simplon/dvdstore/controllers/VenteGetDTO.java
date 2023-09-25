package com.simplon.dvdstore.controllers;

import java.util.Date;

public record VenteGetDTO (Long id, ClientDTO client, DvdDTO dvd, int quantity, float total, Date date) {}
