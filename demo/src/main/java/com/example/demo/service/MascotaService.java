package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Mascota;
public interface MascotaService {

    public Mascota SearchById(Long id);
 
    public Collection<Mascota> SearchAll();

    public void deleteById(Long id);

    public void updateMascota(Mascota mascota);

    public void add(Mascota mascota);
}
