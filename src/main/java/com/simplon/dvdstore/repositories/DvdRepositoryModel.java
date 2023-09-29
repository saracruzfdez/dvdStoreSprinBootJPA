package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dvdmodel")
@Getter
@Setter
@NoArgsConstructor
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "prix")
    private Float prix;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name="imagePath")
    private String imagePath;


    public DvdRepositoryModel(String name, String genre, Integer quantity, Float prix, String imagePath) {
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.prix = prix;
        this.imagePath = imagePath;
    }

}