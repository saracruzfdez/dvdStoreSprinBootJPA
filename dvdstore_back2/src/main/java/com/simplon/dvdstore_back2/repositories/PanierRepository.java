package com.simplon.dvdstore_back2.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends CrudRepository<PanierRepositoryModel, Long> {
    @Transactional
    @Modifying
    @Query(value = "CALL total()", nativeQuery = true)

    void total();

}
