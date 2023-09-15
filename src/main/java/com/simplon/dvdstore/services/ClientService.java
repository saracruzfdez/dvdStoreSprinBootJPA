package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.ClientRepository;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public boolean add(ClientServiceModel clientServiceModel) {
        ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(clientServiceModel.getName(), clientServiceModel.getEmail());
        ClientRepositoryModel clientRepositoryModelReturned = clientRepository.save(clientRepositoryModel);
        return clientRepositoryModelReturned != null;
    }

    public ArrayList<ClientServiceModel> getAll() {
        ArrayList<ClientServiceModel> clientServiceModel = new ArrayList<>();
        ArrayList<ClientRepositoryModel> clientRepositoryModelArrayList = clientRepository.findAll();
        for (ClientRepositoryModel j : clientRepositoryModelArrayList) {
            clientServiceModel.add(new ClientServiceModel(j.getName(), j.getEmail()));
        }
        return clientServiceModel;
    }
}