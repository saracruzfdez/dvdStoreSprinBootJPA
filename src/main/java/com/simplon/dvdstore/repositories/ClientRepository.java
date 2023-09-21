package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // Anotación que marca la clase como un repositorio Spring
public interface ClientRepository extends CrudRepository<ClientRepositoryModel, Long>{

    //ClientRepositoryModel save(ClientRepositoryModel clientRepositoryModel);

    ArrayList<ClientRepositoryModel> findAll();

    //void delete(ClientRepositoryModel clientRepositoryModel);

}


