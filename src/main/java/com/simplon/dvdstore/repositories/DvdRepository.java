package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DvdRepository extends CrudRepository<DvdRepositoryModel, Long> {
    // DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);

    ArrayList<DvdRepositoryModel> findAll();

    // void delete(DvdRepositoryModel dvdRepositoryModel);
}