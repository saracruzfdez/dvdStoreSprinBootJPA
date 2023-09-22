package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DvdRepository dvdRepository;

    public boolean add(VenteServiceModel venteServiceModel) {

        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(venteServiceModel.getClient_id()).get();

        DvdRepositoryModel dvdRepositoryModel = dvdRepository.findById(venteServiceModel.getDvd_id()).get();

        float total;
        total = venteServiceModel.getQuantity() * dvdRepositoryModel.getPrix();

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(clientRepositoryModel, dvdRepositoryModel, venteServiceModel.getQuantity(), total);

        Object object = venteRepository.save(venteRepositoryModel);

        return object != null;

    }

    public ArrayList<VenteServiceModel> getAll() {

        ArrayList<VenteServiceModel> venteServiceModel = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModelArrayList = venteRepository.findAll();

        for (VenteRepositoryModel x : venteRepositoryModelArrayList) {

            venteServiceModel.add(new VenteServiceModel(x.getClientRepositoryModel().getId(), x.getDvdRepositoryModel().getId(), x.getQuantity(), x.getTotal()));

        }

        return venteServiceModel;

    }
}
