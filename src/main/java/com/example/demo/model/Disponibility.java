package com.example.demo.model;

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

public class Disponibility {
    @Id
    private Long iddisp;


    @Column(name = "_eco")
    private Long nrEco;

    @Column(name = "_bussiness")
    private Long nrBus;

    @Column(name = "_first")
    private Long nrFirst;


}
