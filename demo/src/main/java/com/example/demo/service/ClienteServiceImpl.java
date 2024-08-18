package com.example.demo.service;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Collection<Cliente> SearchAll(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente SearchById(Long id) {
        return clienteRepository.findById(id);
    } 

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.add(cliente);
    }
    
    @Override 
    public Cliente eliminarCliente(Cliente cliente){
        return clienteRepository.delete(cliente);
    }
    
    @Override
    public void agregarMascota(Long cliente_id, Mascota mascota){
        Cliente auxCliente = clienteRepository.findById(cliente_id);
        if(auxCliente != null){
            auxCliente.getMascotas().put(mascota.getId(), mascota);
            clienteRepository.add(auxCliente);               
        }
    }

    @Override
    public void eliminarMascota(Long cliente_id, Mascota mascota){
        Cliente auxCliente = clienteRepository.findById(cliente_id);
        if(auxCliente != null){
            auxCliente.getMascotas().put(mascota.getId(), mascota);
            clienteRepository.add(auxCliente);
        }
    }
}
