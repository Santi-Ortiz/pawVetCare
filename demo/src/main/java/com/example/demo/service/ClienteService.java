package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ClientExistingException;
import com.example.demo.controller.ClientUpdatingException;
import com.example.demo.controller.NotClientFoundException;
import com.example.demo.controller.NotPetFoundException;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;

    @Transactional
    public boolean agregarMascota(Long clienteId, Mascota mascota) {
        Cliente cliente = clienteRepository.findByCedula(clienteId);
        
        if (cliente == null) {
            return false; 
        }

        if (mascota.getId() != null) {
            Mascota existingMascota = mascotaRepository.findById(mascota.getId()).orElse(null);
            
            if (existingMascota != null) {
                existingMascota.setNombre(mascota.getNombre());
                existingMascota.setRaza(mascota.getRaza());
                existingMascota.setEdad(mascota.getEdad());
                existingMascota.setPeso(mascota.getPeso());
                existingMascota.setEnfermedad(mascota.getEnfermedad());
                existingMascota.setFoto(mascota.getFoto());
                existingMascota.setEstado(mascota.getEstado());
                mascota = existingMascota; 
            } else {
                return false;
            }
        } else {
            mascota.setCliente(cliente);
        }

        mascota.setCliente(cliente);
        mascotaRepository.save(mascota);
        return true;
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
        // Cliente cliente = clienteRepository.findByCedula(cedula);

        return clienteRepository.findByCedula(cedula);
        
    }

    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Collection<Cliente> mostrarTodos(){
        return clienteRepository.findAll();
    }

    public void add(Cliente cliente){
        if(clienteRepository.findByCedula(cliente.getCedula()) != null){
            throw new ClientExistingException(cliente.getCedula());
        } else{
            clienteRepository.save(cliente);
        }
    }

    // public void editarCliente(Cliente cliente){
    //     clienteRepository.deleteById(cliente.getCedula());
    // }

    public void update(Cliente cliente){
        //clienteRepository.save(cliente);
        Cliente clienteExistente = clienteRepository.findByCedula(cliente.getCedula());
        if (clienteExistente != null && !clienteExistente.getId().equals(cliente.getId())) {
            throw new ClientUpdatingException(cliente.getCedula());
        } else {
            clienteRepository.save(cliente);
        }
    }
}
