package com.simplon.dvdstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Anotación que marca esta clase como la clase principal de una aplicación Spring Boot
@SpringBootApplication
@EnableFeignClients(basePackages = "com.simplon.dvdstore")
// Definición de la clase DvdstoreApplication
public class DvdstoreApplication {

    // Método principal que inicia la aplicación
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(DvdstoreApplication.class, args);
    }
}
