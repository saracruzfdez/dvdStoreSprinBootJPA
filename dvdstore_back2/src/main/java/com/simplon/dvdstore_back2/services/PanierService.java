package com.simplon.dvdstore_back2.services;

import com.simplon.dvdstore_back2.repositories.PanierRepository;
import com.simplon.dvdstore_back2.repositories.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanierService {

    private final PanierRepository panierRepository;

    @Autowired
    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }



    public boolean add(PanierServiceModel panierServiceModel) {
        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(panierServiceModel.getVente_id(), panierServiceModel.getClient_id(), panierServiceModel.getDvd_id(), panierServiceModel.getDvd_price(), panierServiceModel.getDvd_quantity());


        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);


        panierRepository.total();

 return panierRepositoryModelReturned !=null;


    }
}