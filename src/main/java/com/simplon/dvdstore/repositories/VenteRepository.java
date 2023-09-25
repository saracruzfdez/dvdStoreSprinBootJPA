package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VenteRepository extends CrudRepository<VenteRepositoryModel, Long> {

    VenteRepositoryModel save(ClientRepositoryModel clientRepositoryModel);

    ArrayList<VenteRepositoryModel> findAll();

}