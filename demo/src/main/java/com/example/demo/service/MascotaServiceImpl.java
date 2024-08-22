/*package com.example.demo.service;

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
    public Mascota SearchById(Long id){
        Optional<Mascota> auxMascota = repo.findById(id);
        return auxMascota.get();
    }

    @Override
    public Collection<Mascota> SearchAll(){
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id){
        repo.deleteById(id);
    }
    
    @Override
    public void updateMascota(Mascota mascota){
        repo.save(mascota);
    }

    @Override
    public void add(Mascota mascota){
        repo.save(mascota);
    }
}
*/