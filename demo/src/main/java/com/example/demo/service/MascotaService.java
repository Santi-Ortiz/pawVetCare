package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ClientUpdatingException;
import com.example.demo.controller.NotPetFoundException;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Tratamiento;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.TratamientoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private TratamientoRepository repoTratamiento;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Mascota SearchById(Long id){
        Optional<Mascota> auxMascota = mascotaRepository.findById(id);
        return auxMascota.get();
    }
    
    @Transactional
    public List<Mascota> SearchAll(){
        return mascotaRepository.findAll();
    }


    @Transactional
    public void borrarMascota(Long id){
       
        Mascota mascota = mascotaRepository.findById(id).orElseThrow(() -> new NotPetFoundException(id));

        Cliente cliente = mascota.getIdCliente();
        if (cliente != null) {
            cliente.getMascotas().remove(mascota);
        }

        mascotaRepository.delete(mascota);
    }

    @Transactional
    public void updateMascota(Mascota mascota){
        //mascotaRepository.save(mascota);
        Cliente clienteExistente = clienteRepository.findByCedula(mascota.getIdCliente().getCedula());
        if (clienteExistente != null && !clienteExistente.getId().equals(mascota.getIdCliente().getId())) {
            throw new ClientUpdatingException(mascota.getIdCliente().getCedula());
        } else {
            mascotaRepository.save(mascota);
        }
    }

    @Transactional
    public void add(Mascota mascota){
        mascotaRepository.save(mascota);
    }
}