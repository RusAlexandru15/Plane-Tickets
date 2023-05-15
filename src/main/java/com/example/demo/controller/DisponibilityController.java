package com.example.demo.controller;

import com.example.demo.model.Disponibility;
import com.example.demo.model.Flight;
import com.example.demo.service.DispService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DisponibilityController {
    @Autowired
    DispService dispService;

    /** returns all availabilities from the database */
    @GetMapping("/disps")
    public List<Disponibility> getDispsControlled(){
        return dispService.getDisps();
    }


    /** returns a disponibility according to  its id */
    @GetMapping("/disps/getDisp{id}")
    public Disponibility getDispByIdControlled(@PathVariable Long id){
        return  dispService.getDispById(id);
    }

}
