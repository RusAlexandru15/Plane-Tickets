package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ziua; //format "dd-MM-yyyy"
    private String from;
    private String to;
    private int iddisp;

    public Long getId() {
        return id;
    }

    public String getZiua() {
        return ziua;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getIddisp() {
        return iddisp;
    }
}

