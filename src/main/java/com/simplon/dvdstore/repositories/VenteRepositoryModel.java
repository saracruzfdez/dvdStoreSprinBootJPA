package com.simplon.dvdstore.repositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simplon.dvdstore.services.ClientServiceModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity  // Esta clase es una entidad JPA que se mapea a una tabla en la base de datos.
@Table(name = "ventes")  // La tabla se llama "ventes".
@Getter
@Setter
@NoArgsConstructor
public class VenteRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Clave primaria autogenerada.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientRepositoryModel clientRepositoryModel;  // Referencia al cliente que realizó la venta.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dvd_id")
    private DvdRepositoryModel dvdRepositoryModel;  // Referencia al DVD vendido.

    @Column(name = "total")
    private Float total;  // Importe total de la venta.

    @Column(name = "date")
    @CreationTimestamp  // La fecha se establece automáticamente al crear la venta.
    @DateTimeFormat(pattern = "dd/MM/yyyy")  // Formato de fecha.
    private LocalDate localDate;  // Fecha de la venta.

    @Column(name = "quantity")
    private int quantity;  // Cantidad de DVDs vendidos en esta transacción.

    // Constructor para crear una instancia de VenteRepositoryModel al registrar una venta.
    public VenteRepositoryModel(ClientRepositoryModel clientRepositoryModel, DvdRepositoryModel dvdRepositoryModel, int quantity, float total) {
        this.clientRepositoryModel = clientRepositoryModel;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.quantity = quantity;
        //this.total = total;
        this.total=quantity * dvdRepositoryModel.getPrix();
    }
}
