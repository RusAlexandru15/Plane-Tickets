package com.example.demo.service;

import com.example.demo.model.Disponibility;

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

}
