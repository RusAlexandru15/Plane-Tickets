package com.example.demo.service;

import com.example.demo.model.Disponibility;

import com.example.demo.model.Flight;
import com.example.demo.repository.DispRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** service class for the flight's disponibility */
@Service
public class DispService {
    @Autowired
    private DispRepository dispRepository;

    /**selects all the disps from DB*/
    public List<Disponibility> getDisps(){
        return dispRepository.findAll();
    }

    /**selects the disponibility with specified id*/
    public Disponibility getDispById(long id){
        return dispRepository.findById(id).orElse(null);
    }

    //poti sa faci aici request sa reduca un loc din anumita clasa (eco/busines/first) si in controller @PUT_REQUEST




}
