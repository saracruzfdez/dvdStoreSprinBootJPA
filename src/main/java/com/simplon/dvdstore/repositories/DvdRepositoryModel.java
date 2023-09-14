package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Anotación que marca la clase como una entidad JPA
@Table(name = "dvdmodel") // Anotación que especifica el nombre de la tabla en la base de datos
@Getter // Anotación de Lombok para generar automáticamente los métodos getter
@Setter
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos

public class DvdRepositoryModel {
    @Id // Marca el campo 'id' como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.AUTO) // Especifica cómo se generará el valor de la clave primaria
    private Long id;

    @Column(name = "name") // Anotación que mapea el campo 'name' a una columna en la tabla de la base de datos
    private String name;

    @Column(name = "genre") // Anotación que mapea el campo 'genre' a una columna en la tabla de la base de datos
    private String genre;

    // Constructor con argumentos para crear instancias de la entidad con valores iniciales
    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}

/*En este código, se define una entidad JPA llamada DvdRepositoryModel que representa una entidad en la base de datos. Aquí están los comentarios para cada parte del código:

    @Entity: Esta anotación marca la clase como una entidad JPA, lo que significa que se mapeará a una tabla en la base de datos.

    @Table(name = "dvdmodel"): Esta anotación especifica el nombre de la tabla en la base de datos a la que se mapeará esta entidad.

    @Getter: Esta anotación de Lombok genera automáticamente los métodos getter para los campos de la entidad.

    @NoArgsConstructor: Esta anotación de Lombok genera automáticamente un constructor sin argumentos, que es requerido por JPA para crear instancias de la entidad.

    @Id: Esta anotación marca el campo 'id' como la clave primaria de la entidad.

    @GeneratedValue(strategy = GenerationType.AUTO): Esta anotación especifica cómo se generará automáticamente el valor de la clave primaria. En este caso, se utiliza la estrategia automática proporcionada por el proveedor de JPA (por ejemplo, auto-incremento en MySQL).

    @Column(name = "name") y @Column(name = "genre"): Estas anotaciones mapean los campos 'name' y 'genre' a columnas en la tabla de la base de datos con los nombres especificados.

    El constructor DvdRepositoryModel(String name, String genre) permite crear instancias de la entidad proporcionando valores iniciales para los campos 'name' y 'genre'. */
