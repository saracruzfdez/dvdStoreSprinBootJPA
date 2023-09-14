package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.DvdModelService;
import com.simplon.dvdstore.services.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("dvds")
public class DvsStoreController {
    @Autowired
    DvdStoreService dvdStoreService; // Inyección de dependencia de DvdStoreService

    @PostMapping
    public boolean addDvdToStore(@RequestBody DvdStoreDTO dvdStoreDTO) {
        // Crear un objeto DvdModelService a partir de los datos proporcionados en dvdStoreDTO
        DvdModelService dvdModelService = new DvdModelService(dvdStoreDTO.getName(), dvdStoreDTO.getGenre());

        // Llamar al método "add" del servicio de la tienda de DVD para agregar el DVD al almacén
        return dvdStoreService.add(dvdModelService);
    }

    @GetMapping
    public ArrayList<DvdStoreDTO> getAll() {
        // Crear una lista vacía para almacenar los DTO de la tienda de DVD
        ArrayList<DvdStoreDTO> dvdStoreDTOS = new ArrayList<>();

        // Obtener todos los DVDs del servicio de la tienda de DVD
        ArrayList<DvdModelService> dvdServiceModelArrayList = dvdStoreService.getAll();

        // Iterar a través de la lista de DVDs obtenidos y crear DTO para cada uno
        for (DvdModelService x : dvdServiceModelArrayList) {
            dvdStoreDTOS.add(new DvdStoreDTO(x.getName(), x.getGenre()));
        }

        // Devolver la lista de DTO de la tienda de DVD
        return dvdStoreDTOS;
    }

    @GetMapping("/{id}")
    public DvdStoreDTO getById(@PathVariable Long id) {
        // Obtener un DVD específico del servicio de la tienda de DVD por su ID
        DvdModelService dvdModelService = dvdStoreService.getById(id);

        // Crear un DTO basado en el DVD obtenido y devolverlo
        return new DvdStoreDTO(dvdModelService.getName(), dvdModelService.getGenre());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        dvdStoreService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO){

        return DvdStoreService.update(id, new DvdModelService(dvdStoreDTO.getName(), dvdStoreDTO.getGenre()));

    }
}

/*
Este código parece ser una clase de controlador de Spring Boot para una tienda de DVD. Aquí están las principales funciones que realiza:

    El controlador está mapeado a la URL base "dvds".
    Utiliza la anotación @Autowired para inyectar una instancia de DvdStoreService, que es un servicio que maneja las operaciones relacionadas con la tienda de DVD.

Las tres operaciones principales que se definen en este controlador son las siguientes:

    addDvdToStore: Este método HTTP POST toma un objeto DvdStoreDTO del cuerpo de la solicitud, crea un DvdModelService a partir de él y luego llama al método add en el servicio de la tienda de DVD para agregar el DVD al almacén. Devuelve un valor booleano que indica si la operación tuvo éxito.

    getAll: Este método HTTP GET obtiene una lista de todos los DVDs en la tienda de DVD a través del servicio y luego crea una lista de objetos DvdStoreDTO a partir de ellos. Finalmente, devuelve la lista de DTO.

    getById: Este método HTTP GET toma un parámetro de ruta que representa el ID de un DVD y llama al servicio para obtener ese DVD específico por su ID. Luego crea un objeto DvdStoreDTO basado en el DVD obtenido y lo devuelve como respuesta.

En resumen, este controlador maneja las operaciones relacionadas con la tienda de DVD, como agregar un DVD, obtener todos los DVDs y obtener un DVD por su ID. Utiliza objetos DTO (DvdStoreDTO) para transportar datos entre el cliente y el servidor.
*/

/*
* En Spring Boot, los controladores, repositorios y servicios son componentes clave en la arquitectura de una aplicación. Spring Boot es un framework que se basa en Spring Framework y simplifica considerablemente la creación de aplicaciones Java, incluidas aplicaciones web. Aquí tienes una explicación más específica de cómo se aplican estos conceptos en Spring Boot:

    Controladores:
        Propósito en Spring Boot: Los controladores en Spring Boot se crean mediante la anotación @RestController o @Controller y se utilizan para manejar las solicitudes HTTP, ya sea para devolver datos JSON, XML o renderizar vistas HTML.
        Funciones:
            Interpretan y validan los datos de entrada del cliente a través de las solicitudes HTTP.
            Usan métodos anotados con @GetMapping, @PostMapping, etc., para definir las rutas y métodos HTTP que gestionan.
            Llaman a los servicios para realizar operaciones de negocio y preparan los datos para su respuesta al cliente.

    Repositorios:
        Propósito en Spring Boot: Los repositorios en Spring Boot se crean utilizando interfaces que extienden CrudRepository o JpaRepository de Spring Data JPA. Estas interfaces proporcionan métodos predefinidos para interactuar con la base de datos de manera sencilla.
        Funciones:
            Definen métodos para realizar operaciones CRUD en las entidades de la aplicación.
            Spring Data JPA proporciona implementaciones automáticas para estas operaciones, lo que elimina la necesidad de escribir consultas SQL manualmente.
            Permiten acceder y manipular datos en la base de datos de manera eficiente y segura.

    Servicios:
        Propósito en Spring Boot: Los servicios en Spring Boot son componentes que contienen la lógica de negocio de la aplicación. Se crean utilizando la anotación @Service.
        Funciones:
            Contienen métodos que encapsulan la lógica de negocio de la aplicación.
            Realizan operaciones específicas, aplican reglas de negocio y coordinan las interacciones entre diferentes repositorios o componentes de servicios.
            Los controladores llaman a estos servicios para realizar operaciones y obtener resultados para responder a las solicitudes HTTP.

La interacción típica entre estos componentes es la siguiente:

    Un cliente (por ejemplo, un navegador web) realiza una solicitud HTTP que llega a un controlador en Spring Boot.

    El controlador interpreta la solicitud, valida los datos y llama a los métodos apropiados de los servicios para realizar operaciones de negocio.

    Los servicios utilizan los repositorios para acceder a los datos almacenados en la base de datos, aplican la lógica de negocio y devuelven los resultados al controlador.

    El controlador prepara los datos de respuesta y devuelve una respuesta HTTP al cliente.

En resumen, en Spring Boot, los controladores gestionan las solicitudes y las respuestas HTTP, los repositorios facilitan el acceso a la base de datos y los servicios encapsulan la lógica de negocio de la aplicación. Estos componentes trabajan juntos para construir una aplicación web robusta y escalable.*/
