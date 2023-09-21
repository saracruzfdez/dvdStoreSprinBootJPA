package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Anotación que marca la clase como una entidad JPA
@Table(name = "client") // Anotación que especifica el nombre de la tabla en la base de datos
@Getter // Anotación de Lombok para generar automáticamente los métodos getter
@Setter
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public ClientRepositoryModel(String name, String email) {
        this.name = name;
        this.email = email;
    }
}