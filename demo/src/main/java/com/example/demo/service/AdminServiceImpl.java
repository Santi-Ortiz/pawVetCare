package com.example.demo.service;

import com.example.demo.entity.Mascota;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.MascotaRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    MascotaRepository repoMascota;

    @Autowired
    AdminRepository repoAdmin;

    @Override
    public Mascota SearchPetById(Long id) {
        return repoMascota.findById(id);
    }

    @Override
    public Collection<Mascota> SearchAllPets() {
        return repoMascota.findAll();
    }
    
}
