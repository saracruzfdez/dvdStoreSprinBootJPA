package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends CrudRepository<VenteRepositoryModel, Long> {

VenteRepositoryModel save(ClientRepositoryModel clientRepositoryModel);



}
