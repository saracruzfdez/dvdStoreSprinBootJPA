package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel, Long> {

    DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
}
