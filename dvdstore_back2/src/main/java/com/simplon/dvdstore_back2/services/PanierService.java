package com.simplon.dvdstore_back2.services;

import com.simplon.dvdstore_back2.mappers.PanierMapper;
import com.simplon.dvdstore_back2.repositories.PanierRepository;
import com.simplon.dvdstore_back2.repositories.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PanierServiceModel> getAllPaniers() {
        List<PanierRepositoryModel> panierRepositoryModels = (List<PanierRepositoryModel>) panierRepository.findAll();
        return panierRepositoryModels.stream()
                .map(panierMapper::repositoryToServiceModel)
                .collect(Collectors.toList());
    }

    public PanierServiceModel getPanierById(Long panierId) {
        Optional<PanierRepositoryModel> panierRepositoryModelOptional = panierRepository.findById(panierId);
        if (panierRepositoryModelOptional.isPresent()){
            return panierMapper.repositoryToServiceModel(panierRepositoryModelOptional.get());
        } else {
            return null;
        }
    }

    public boolean updatePanier(Long panierId, PanierServiceModel updatedPanier) {
        // Verificar si el elemento con el ID especificado existe en la base de datos
        Optional<PanierRepositoryModel> existingPanier = panierRepository.findById(panierId);

        if (existingPanier.isPresent()) {
            // Actualizar los campos del elemento existente con los datos del DTO actualizado
            PanierRepositoryModel panierToUpdate = existingPanier.get();

            panierToUpdate.setClient_id(updatedPanier.getClient_id());
            panierToUpdate.setDvd_id(updatedPanier.getDvd_id());
            panierToUpdate.setDvd_price(updatedPanier.getDvd_price());
            panierToUpdate.setDvd_quantity(updatedPanier.getDvd_quantity());

            // Guardar la actualización en la base de datos y calcular de nuevo el precio total
            panierRepository.save(panierToUpdate);
            panierRepository.total();

            return true;
        } else {
            // Manejo de excepción o retorno de falso si el elemento no se encuentra
            return false;
        }
    }

    public boolean deletePanier(Long panierId) {
        // Verificamos que el registro existe en la base de datos :
        Optional<PanierRepositoryModel> existingPanier = panierRepository.findById(panierId);
        if(existingPanier.isPresent()){
            panierRepository.delete(existingPanier.get());
            return true;
        }else{
            return false;
        }
    }

      /* public boolean add(PanierServiceModel panierServiceModel) {
        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(panierServiceModel.getVente_id(), panierServiceModel.getClient_id(), panierServiceModel.getDvd_id(), panierServiceModel.getDvd_price(), panierServiceModel.getDvd_quantity());
        PanierRepositoryModel panierRepositoryModelReturned = panierRepository.save(panierRepositoryModel);
        panierRepository.total();
        return panierRepositoryModelReturned != null;
    } */
}