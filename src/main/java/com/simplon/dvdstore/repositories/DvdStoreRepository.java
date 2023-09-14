package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // Anotación que marca la clase como un repositorio Spring
public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel, Long> {

    // Método para guardar un DVD en la base de datos
    DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);

    // Método para buscar y devolver todos los DVDs en la base de datos
    ArrayList<DvdRepositoryModel> findAll();

    void delete(DvdRepositoryModel dvdRepositoryModel);
}
/*
    @Repository: Esta anotación marca la interfaz DvdStoreRepository como un repositorio de Spring, lo que indica que esta interfaz se utilizará para interactuar con la base de datos.

    interface DvdStoreRepository: Esta interfaz extiende CrudRepository, que es una interfaz proporcionada por Spring Data JPA para realizar operaciones CRUD (Create, Read, Update, Delete) en una entidad.

    CrudRepository<DvdRepositoryModel, Long>: Esta línea especifica que DvdStoreRepository se utilizará para gestionar entidades del tipo DvdRepositoryModel y que la clave primaria de DvdRepositoryModel es de tipo Long.

    DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel): Este método declara una operación para guardar un objeto DvdRepositoryModel en la base de datos. Spring Data JPA proporciona una implementación predeterminada para esta operación, por lo que no es necesario proporcionar una implementación manual.

    ArrayList<DvdRepositoryModel> findAll(): Este método declara una operación para buscar y devolver todos los objetos DvdRepositoryModel en la base de datos. Spring Data JPA también proporciona una implementación predeterminada para esta operación, lo que facilita la recuperación de todos los registros.

En resumen, esta interfaz DvdStoreRepository define métodos que son esenciales para realizar operaciones de persistencia en la base de datos en relación con la entidad DvdRepositoryModel. Spring Data JPA proporciona implementaciones predeterminadas para estos métodos, lo que simplifica el acceso y manipulación de datos en la base de datos. La anotación @Repository marca la interfaz como un componente de Spring que facilita la inyección de dependencias.


    */
