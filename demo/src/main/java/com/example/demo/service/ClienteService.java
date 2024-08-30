package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.NotClientFoundException;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;

    @Transactional
    public void agregarMascota(Long clienteId, Mascota mascota) {
        Cliente cliente = clienteRepository.findByCedula(clienteId);

        // Si la mascota ya existe en la base de datos, solo actualiza el vínculo
        if (mascota.getId() != null) {
            Mascota existingMascota = mascotaRepository.findById(mascota.getId())
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada con ID: "));
            existingMascota.setNombre(mascota.getNombre());
            existingMascota.setRaza(mascota.getRaza());
            existingMascota.setEdad(mascota.getEdad());
            existingMascota.setPeso(mascota.getPeso());
            existingMascota.setEnfermedad(mascota.getEnfermedad());
            existingMascota.setFoto(mascota.getFoto());
            existingMascota.setEstado(mascota.getEstado());
            mascota = existingMascota; 
        } else {
            mascota.setIdCliente(cliente);
        }
        mascota.setIdCliente(cliente);
        mascotaRepository.save(mascota);
    }

    @Transactional
    public void eliminarMascota(Long clienteId, Long mascotaId) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new NotClientFoundException(clienteId));

        Mascota mascota = mascotaRepository.findById(mascotaId)
            .orElseThrow(() -> new NotClientFoundException(clienteId));

        cliente.getMascotas().remove(mascota);
        clienteRepository.save(cliente);
        mascotaRepository.delete(mascota);
    }
    
    public Cliente obtenerCliente(Long id){
        Cliente cliente = clienteRepository.findByCedula(id); 
        return cliente;
    }

    public Cliente obtenerClientePorCedula(Long cedula){
        Cliente cliente = clienteRepository.findByCedula(cedula);

        if(cliente != null){
            return clienteRepository.findByCedula(cedula);
        } else {    
            throw new NotClientFoundException(cedula);
        }
    }

    public void eliminarCliente(Long id){
        Cliente auxcliente = clienteRepository.findByCedula(id);
        auxcliente.getMascotas().clear();
        clienteRepository.save(auxcliente);
        clienteRepository.deleteById(id);
    }

    public void agregarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Collection<Cliente> mostrarTodos(){
        return clienteRepository.findAll();
    }
    public void update(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
