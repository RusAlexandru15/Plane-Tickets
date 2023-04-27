package com.example.demo.repository;

import com.example.demo.model.Disponibility;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface DispRepository extends JpaRepository<Disponibility,Long> {


}
