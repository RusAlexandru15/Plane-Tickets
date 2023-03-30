package com.example.demo.model;

import com.example.demo.repository.DispRepository;
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
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "_ziua")
    private String ziua; //format "dd-MM-yyyy"

    @Column(name = "_from")
    private String from;

    @Column(name = "_to")
    private String to;


    @Column(name = "iddisp")
    private Long disponibilityID;





}

