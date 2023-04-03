package com.example.demo.model;

import com.example.demo.utilities.PriceTickets;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket implements PriceTickets {

    @Id //nu folosesc la nimic idBilet
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "idClient")
    private Long idClient;

    @Column(name = "idZbor")
    private Long idZbor;

    @Column(name = "_clasa")
    private String clasa;

    @Column (name="_pret")
    private Long pret;

    @Override
    public void priceIncrease(float amount) {
        this.pret= (long) (this.pret+amount*this.pret);
    }

    @Override
    public void priceReduce(float amount) {
        this.pret= (long) (this.pret-amount*this.pret);
    }
}
