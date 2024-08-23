/*package com.example.demo.service;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    MascotaRepository repoMascota;

    @Override
    public Collection<Cliente> SearchAll(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente SearchById(Long id) {
        return clienteRepository.findById(id);
    } 

    @Override
    public Cliente SearchByCedula(Integer cedula) {
        return clienteRepository.findByCedula(cedula);
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
    public Collection<Mascota> buscarMascotas(){
        return clienteRepository.findAllPets();
    }

    @Override
    public Mascota buscarMascotaPorID(Long id){
        return repoMascota.findById(id);
    }
    
    @Override
    public void agregarMascota(Long cliente_id, Mascota mascota){
        Cliente auxCliente = clienteRepository.findById(cliente_id);
        if(auxCliente != null){
            auxCliente.getMascotas().put(mascota.getId(), mascota);
            clienteRepository.add(auxCliente);         
        }
        clienteRepository.findById(cliente_id).getMascotas().put(mascota.getId(), mascota);
    }

    @Override
    public void eliminarMascota(Long cliente_id, Mascota mascota){
        Cliente auxCliente = clienteRepository.findById(cliente_id);
        if(auxCliente != null){
            auxCliente.getMascotas().remove(mascota.getId());
            clienteRepository.add(auxCliente);
        }
    }

    @Override
    public void add(Cliente cliente) {
        clienteRepository.add(cliente);
    }
}

*/