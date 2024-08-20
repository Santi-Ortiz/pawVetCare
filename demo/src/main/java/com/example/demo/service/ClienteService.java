package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.ClienteRepository;
//import com.example.demo.repository.MascotaRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    //private MascotaRepository mascotaRepository;

    public void agregarMascota(Long cliente_id, Mascota mascota){
        Cliente cliente = clienteRepository.findById(cliente_id).get();
        for(Mascota m : cliente.getMascotas()){
            if(m.getId() == mascota.getId()){
                cliente.getMascotas().add(mascota);
                break;
            }
        }
        clienteRepository.save(cliente);               
    }

    public void eliminarMascota(Long cliente_id, Mascota mascota){
        Cliente cliente = clienteRepository.findById(cliente_id).get();
        for(Mascota m : cliente.getMascotas()){
            if(m.getId() == mascota.getId()){
                cliente.getMascotas().remove(mascota);
                break;
            }
        }
        clienteRepository.save(cliente);   
    }
    
    public Cliente obtenerCliente(Long id){
        Optional<Cliente> auxCliente = clienteRepository.findById(id);
        Cliente cliente = auxCliente.get(); 
        return cliente;
    }

    public Cliente obtenerClientePorCedula(Integer cedula){
        return clienteRepository.findByCedula(cedula);
    }

    public void eliminarCliente(Long id){
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
