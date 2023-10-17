package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.ClientRepository;
import com.simplon.dvdstore.repositories.ClientRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

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
            clientServiceModel.add(new ClientServiceModel(Optional.ofNullable(j.getId()), j.getName(), j.getEmail()));
        }
        return clientServiceModel;
    }

    public ClientServiceModel getById(Long id) {
        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(id).get();
        return new ClientServiceModel(Optional.ofNullable(clientRepositoryModel.getId()),clientRepositoryModel.getName(), clientRepositoryModel.getEmail());
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public boolean update(@PathVariable Long id, @RequestBody ClientServiceModel clientServiceModel) {
        try {
            ClientRepositoryModel clientRepositoryModel = clientRepository.findById(id).get();
            clientRepositoryModel.setName(clientServiceModel.getName());
            clientRepositoryModel.setEmail(clientServiceModel.getEmail());
            clientRepository.save(clientRepositoryModel);
            return clientServiceModel != null;
        } catch (Exception e) {
            return false;
        }
    }
}