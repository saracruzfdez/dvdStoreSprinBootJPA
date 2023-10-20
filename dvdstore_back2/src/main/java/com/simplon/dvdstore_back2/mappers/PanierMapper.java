package com.simplon.dvdstore_back2.mappers;

import com.simplon.dvdstore_back2.controllers.PanierDTO;
import com.simplon.dvdstore_back2.repositories.PanierRepositoryModel;
import com.simplon.dvdstore_back2.services.PanierServiceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PanierMapper {

    // POUR LE POST :
    PanierServiceModel dtoToServiceModel(PanierDTO panierDTO);

    PanierRepositoryModel serviceToRepository(PanierServiceModel serviceModel);

    // POUR LE GET :
    PanierServiceModel repositoryToServiceModel(PanierRepositoryModel repositoryModel);

    PanierDTO panierServiceModelToDTO(PanierServiceModel panierServiceModel);

}