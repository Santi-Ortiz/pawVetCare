package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;
import java.util.*;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository repo;

    public Mascota SearchById(Long id){
        Optional<Mascota> auxMascota = repo.findById(id);
        return auxMascota.get();
    }
 
    public List<Mascota> SearchAll(){
        return repo.findAll();
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public void updateMascota(Mascota mascota){
        repo.save(mascota);
    }

    public void add(Mascota mascota){
        repo.save(mascota);
    }
}