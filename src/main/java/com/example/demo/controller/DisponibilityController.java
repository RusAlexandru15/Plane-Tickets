package com.example.demo.controller;

import com.example.demo.model.Disponibility;

import com.example.demo.service.DispService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DisponibilityController {
    @Autowired
    DispService dispService;

    @GetMapping("/disps")
    public List<Disponibility> getDispsControlled(){
        return dispService.getDisps();
    }

}
