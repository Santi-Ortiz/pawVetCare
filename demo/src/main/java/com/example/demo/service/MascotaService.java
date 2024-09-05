package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Tratamiento;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.TratamientoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository repo;

    @Autowired
    private TratamientoRepository repoTratamiento;

    @Transactional
    public Mascota SearchById(Long id){
        Optional<Mascota> auxMascota = repo.findById(id);
        return auxMascota.get();
    }
    
    @Transactional
    public List<Mascota> SearchAll(){
        return repo.findAll();
    }


    @Transactional
    public void borrarMascota(Long id){
       /*try {
            Optional<Mascota> mascota = repo.findById(id);
            if (mascota.isPresent()) {
                Mascota m = mascota.get();
                System.out.println("Mascota encontrada: " + m);
                repo.delete(m);
                repo.flush();
                System.out.println("Mascota con ID " + id + " eliminada.");
            } else {
                System.out.println("Mascota con ID " + id + " no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la mascota: " + e.getMessage());
        }*/
        Mascota mascota = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));

        // Elimina la mascota de la lista de mascotas del cliente
        Cliente cliente = mascota.getIdCliente();
        if (cliente != null) {
            cliente.getMascotas().remove(mascota);  // Eliminar de la lista del cliente
        }

        // Elimina la mascota
        repo.delete(mascota);
    }

    @Transactional
    public void updateMascota(Mascota mascota){
        repo.save(mascota);
    }

    @Transactional
    public void add(Mascota mascota){
        repo.save(mascota);
    }
}