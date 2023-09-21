package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import lombok.Data;
import lombok.Value;

import java.util.Date;


public record VenteDTO(Long client_id, Long dvd_id, int quantity) {
}

