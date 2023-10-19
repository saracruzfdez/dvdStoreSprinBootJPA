package com.simplon.dvdstore_back2.services;

import com.simplon.dvdstore_back2.mappers.PanierMapper;
import com.simplon.dvdstore_back2.repositories.PanierRepository;
import com.simplon.dvdstore_back2.repositories.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanierService {
    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper;

    @Autowired
    public PanierService(PanierRepository panierRepository, PanierMapper panierMapper) {
        this.panierRepository = panierRepository;
        this.panierMapper = panierMapper;
    }

    public boolean add(PanierServiceModel panierServiceModel) {
        PanierRepositoryModel panierRepositoryModel = panierMapper.serviceToRepository(panierServiceModel);

        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);

        panierRepository.total();

        return panierRepositoryModelReturned != null;
    }

      /* public boolean add(PanierServiceModel panierServiceModel) {
        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(panierServiceModel.getVente_id(), panierServiceModel.getClient_id(), panierServiceModel.getDvd_id(), panierServiceModel.getDvd_price(), panierServiceModel.getDvd_quantity());

        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);


        panierRepository.total();

        return panierRepositoryModelReturned != null;
    } */

}