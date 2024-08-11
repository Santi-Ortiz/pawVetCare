package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{
    
    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota SearchById(int id){
        return repo.findById(id);
    }

    @Override
    public Collection<Mascota> SearchAll(){
        return repo.findAll();
    }
}
