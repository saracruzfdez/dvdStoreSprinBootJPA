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

import java.util.Date;


@Entity
@Table(name = "ventes")
@Getter
@Setter
@NoArgsConstructor
public class VenteRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private ClientRepositoryModel clientRepositoryModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dvd_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private DvdRepositoryModel dvdRepositoryModel;

    @Column(name = "total")
    private Float total;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name="quantity")
    private int quantity;

    public VenteRepositoryModel(ClientRepositoryModel clientRepositoryModel, DvdRepositoryModel dvdRepositoryModel, int quantity) {
        this.clientRepositoryModel = clientRepositoryModel;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.quantity = quantity;
    }
}