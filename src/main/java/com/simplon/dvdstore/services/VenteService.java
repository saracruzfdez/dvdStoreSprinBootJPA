package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DvdRepository dvdRepository;

    public boolean add(VenteServiceModel venteServiceModel) {

        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(venteServiceModel.getClient_id().get()).get();

        DvdRepositoryModel dvdRepositoryModel = dvdRepository.findById(venteServiceModel.getDvd_id().get()).get();

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(clientRepositoryModel, dvdRepositoryModel, venteServiceModel.getQuantity(), venteServiceModel.getTotal());

        Object object = venteRepository.save(venteRepositoryModel);

        return object != null;
    }

    public ArrayList<VenteServiceModel> getAll() {

        ArrayList<VenteServiceModel> venteServiceModelArrayList = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModelArrayList = venteRepository.findAll();

        for (VenteRepositoryModel vente : venteRepositoryModelArrayList) {

            ClientServiceModel clientServiceModel = new ClientServiceModel(vente.getClientRepositoryModel().getName(), vente.getClientRepositoryModel().getEmail());

            DvdServiceModel dvdRepositoryModel = new DvdServiceModel(vente.getDvdRepositoryModel().getName(), vente.getDvdRepositoryModel().getGenre(), vente.getDvdRepositoryModel().getPrix(), vente.getDvdRepositoryModel().getQuantity(), vente.getDvdRepositoryModel().getImagePath());

            venteServiceModelArrayList.add(new VenteServiceModel(Optional.ofNullable(vente.getId()), vente.getQuantity(), vente.getTotal(), Optional.ofNullable(dvdRepositoryModel), Optional.ofNullable(clientServiceModel), vente.getLocalDate()));
        }
        return venteServiceModelArrayList;
    }
}
