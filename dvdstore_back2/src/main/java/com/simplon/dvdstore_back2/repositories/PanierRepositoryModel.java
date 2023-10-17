package com.simplon.dvdstore_back2.repositories;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // Esta clase es una entidad JPA que se mapea a una tabla en la base de datos.
@Table(name = "panier")  // La tabla se llama "panier".
@Getter
@Setter
@NoArgsConstructor
public class PanierRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  // Clave primaria autogenerada.

    @Column(name = "vente_id")
    private Integer vente_id;

    @Column(name = "client_id")
    private Integer client_id;

    @Column(name = "dvd_id")
    private Integer dvd_id;

    @Column(name = "dvd_price")
    private Float dvd_price;

    @Column(name = "dvd_quantity")
    private Integer dvd_quantity;

    @Column(name = "total_price")
    private Float total_price;

public PanierRepositoryModel(Integer vente_id, Integer client_id, Integer dvd_id, Float dvd_price, Integer dvd_quantity){

    this.vente_id = vente_id;
    this.client_id = client_id;
    this.dvd_id = dvd_id;
    this.dvd_price = dvd_price;
    this.dvd_quantity = dvd_quantity;

}
}
