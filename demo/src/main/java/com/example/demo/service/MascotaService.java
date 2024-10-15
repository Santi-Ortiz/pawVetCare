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
    public void borrarMascota(Long id) {
        // Buscar la mascota por su ID
        Mascota mascota = mascotaRepository.findById(id).orElseThrow();

        // Obtener el cliente asociado a la mascota
        Cliente cliente = mascota.getCliente();
        if (cliente != null) {
            // Eliminar la mascota de la lista del cliente
            cliente.getMascotas().remove(mascota);
        }

        // Actualizar los tratamientos asociados
        List<Tratamiento> tratamientos = mascota.getTratamientos();
        for (Tratamiento tratamiento : tratamientos) {
            tratamiento.setMascota(null); // Establecer la referencia a mascota en null
        }
        
        // Guardar los tratamientos actualizados
        repoTratamiento.saveAll(tratamientos);
        
        // Eliminar la mascota
        mascotaRepository.delete(mascota);
    }


    @Transactional
    public void updateMascota(Mascota mascota){
        //mascotaRepository.save(mascota);
        Cliente clienteExistente = clienteRepository.findByCedula(mascota.getCliente().getCedula());
        if (clienteExistente != null && !clienteExistente.getId().equals(mascota.getCliente().getId())) {
            throw new ClientUpdatingException(mascota.getCliente().getCedula());
        } else {
            mascotaRepository.save(mascota);
        }
    }

    @Transactional
    public void add(Mascota mascota){
        mascotaRepository.save(mascota);
    }

    public long contarMascotasActivas(){
        return mascotaRepository.countByEstadoTrue();
    }  

    public long contarMascotasInactivas(){
        return mascotaRepository.countByEstadoFalse();
    }
}