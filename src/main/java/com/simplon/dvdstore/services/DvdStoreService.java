package com.simplon.dvdstore.services;

import com.simplon.dvdstore.controllers.DvdStoreDTO;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service // Anotación que marca la clase como un servicio Spring
public class DvdStoreService {

    @Autowired // Inyección de dependencia de DvdStoreRepository
    DvdStoreRepository dvdStoreRepository;

    // Método para agregar un DVD al almacén
    public boolean add(DvdModelService dvdModelService) {
        // Crear un objeto DvdRepositoryModel a partir de los datos proporcionados por dvdModelService
        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(dvdModelService.getName(), dvdModelService.getGenre());

        // Llamar al método "save" del repositorio para guardar el DVD en la base de datos
        DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save(dvdRepositoryModel);

        // Comprobar si el DVD se guardó exitosamente
        return dvdRepositoryModelReturned != null;
    }

    // Método para obtener todos los DVDs en el almacén
    public ArrayList<DvdModelService> getAll() {
        ArrayList<DvdModelService> dvdModelServices = new ArrayList<>();

        // Obtener todos los DVDs de la base de datos a través del repositorio
        ArrayList<DvdRepositoryModel> dvdRepositoryModelArrayList = dvdStoreRepository.findAll();

        // Iterar a través de la lista de DVDs obtenidos y crear objetos DvdModelService
        for (DvdRepositoryModel x : dvdRepositoryModelArrayList) {
            dvdModelServices.add(new DvdModelService(x.getName(), x.getGenre()));
        }

        // Devolver la lista de objetos DvdModelService
        return dvdModelServices;
    }

    // Método para obtener un DVD por su ID
    public DvdModelService getById(Long id) {
        // Obtener un DVD específico de la base de datos por su ID
        DvdRepositoryModel dvdRepositoryModel = dvdStoreRepository.findById(id).get();

        // Crear un objeto DvdModelService basado en el DVD obtenido y devolverlo
        return new DvdModelService(dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre());
    }

    // Método para eliminar un DVD por su ID
    public void deleteById(Long id) {
        dvdStoreRepository.deleteById(id);
    }

    // Método para actualisar
    public boolean update(@PathVariable Long id, @RequestBody DvdModelService dvdModelService){
    try{
        DvdRepositoryModel dvdRepositoryModel=dvdStoreRepository.findById(id).get();
        dvdRepositoryModel.setName(dvdModelService.getName());
        dvdRepositoryModel.setGenre(dvdModelService.getGenre());
        dvdStoreRepository.save(dvdRepositoryModel);
        return dvdModelService != null;

    }catch (Exception e){
        return false;
        }
    }
}

/*
*     @Service: Esta anotación marca la clase DvdStoreService como un componente de servicio de Spring, lo que significa que esta clase se encarga de la lógica empresarial y se puede inyectar en otras partes de la aplicación.

    @Autowired: Esta anotación se utiliza para inyectar una instancia de DvdStoreRepository en la clase DvdStoreService. Esto permite que DvdStoreService acceda a los métodos proporcionados por DvdStoreRepository para interactuar con la base de datos.

    add(DvdModelService dvdModelService): Este método toma un objeto DvdModelService, crea un objeto DvdRepositoryModel a partir de él, lo guarda en la base de datos utilizando el método save del repositorio y devuelve un valor booleano para indicar si la operación fue exitosa.

    getAll(): Este método obtiene todos los DVDs de la base de datos utilizando el método findAll del repositorio, crea objetos DvdModelService basados en los resultados y los devuelve en forma de una lista.

    getById(Long id): Este método obtiene un DVD específico de la base de datos por su ID utilizando el método findById del repositorio, crea un objeto DvdModelService basado en el resultado y lo devuelve.

*/
