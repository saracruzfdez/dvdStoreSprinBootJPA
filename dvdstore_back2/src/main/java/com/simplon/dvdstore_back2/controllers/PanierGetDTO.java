package com.simplon.dvdstore_back2.controllers;

public record PanierGetDTO (int id, int vente_id, int client_id, int dvd_id, float dvd_price, int dvd_quantity){}
