package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdStoreRepository;

    public boolean add(DvdModelService dvdModelService) {
        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdModelService.getName(), dvdModelService.getGenre());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save(dvdRepositoryModel);

        return dvdRepositoryModelReturned != null;
    }
}
