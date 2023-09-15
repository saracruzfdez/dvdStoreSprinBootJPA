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
    @Column(name = "quantity")
    private Integer quantity;
    public DvdRepositoryModel(String name, String genre, Integer quantity) {
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
    }
}