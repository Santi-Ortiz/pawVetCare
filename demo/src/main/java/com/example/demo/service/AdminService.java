package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Mascota;
public interface AdminService {

    public Mascota SearchPetById(Long id);
 
    public Collection<Mascota> SearchAllPets();

}