package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DvdService {
    @Autowired
    DvdRepository dvdRepository;

    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdServiceModel.getName(), dvdServiceModel.getGenre(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrix(), dvdServiceModel.getImagePath());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdRepository.save(dvdRepositoryModel);
        return dvdRepositoryModelReturned != null;
    }

    public ArrayList<DvdServiceModel> getAll() {

        ArrayList<DvdServiceModel> dvdServiceModel = new ArrayList<>();
        ArrayList<DvdRepositoryModel> dvdRepositoryModelArrayList = dvdRepository.findAll();
        for (DvdRepositoryModel x : dvdRepositoryModelArrayList) {
            dvdServiceModel.add(new DvdServiceModel(Optional.ofNullable(x.getId()), x.getName(), x.getGenre(), x.getQuantity(), x.getPrix(), x.getImage_path()));
        }
        return dvdServiceModel;
    }

    public DvdServiceModel getById(Long id) {
        DvdRepositoryModel dvdRepositoryModel = dvdRepository.findById(id).get();
        return new DvdServiceModel(Optional.ofNullable(dvdRepositoryModel.getId()), dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre(), dvdRepositoryModel.getQuantity(), dvdRepositoryModel.getPrix(), dvdRepositoryModel.getImage_path());
    }

    public void deleteById(Long id) {
        dvdRepository.deleteById(id);
    }

    public boolean update(@PathVariable Long id, @RequestBody DvdServiceModel dvdServiceModel) {
        try {
            DvdRepositoryModel dvdRepositoryModel = dvdRepository.findById(id).get();
            dvdRepositoryModel.setName(dvdServiceModel.getName());
            dvdRepositoryModel.setGenre(dvdServiceModel.getGenre());
            dvdRepositoryModel.setQuantity(dvdServiceModel.getQuantity());
            dvdRepositoryModel.setImage_path(dvdServiceModel.getImagePath());
            dvdRepository.save(dvdRepositoryModel);
            return dvdServiceModel != null;

        } catch (Exception e) {
            return false;
        }
    }
}
