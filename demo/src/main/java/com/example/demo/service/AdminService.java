package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.NotClientFoundException;
import com.example.demo.controller.NotPetFoundException;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.ClienteRepository;
//import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.MascotaRepository;

@Service
public class AdminService {

    @Autowired
    private MascotaRepository repoMascota;

    @Autowired
    private ClienteRepository repoCliente;

    
    public Mascota SearchPetById(Long id) {
        Optional<Mascota> optionalMascota = repoMascota.findById(id);
        if (optionalMascota.isPresent()) {
            return optionalMascota.get();
        } else {
            throw new NotPetFoundException(id);
        }
    }

    public List<Mascota> SearchAllPets() {
        return repoMascota.findAll();
    }

    public List<Cliente> SearchAllClients(){
        return repoCliente.findAll();
    }
    
    public Cliente SearchClientById(Long id){
        Optional<Cliente> optionalCliente = repoCliente.findById(id);
        if(optionalCliente.isPresent())
            return optionalCliente.get();
        else
            throw new NotClientFoundException(id);
    }

    //TODO: CRUD de Admin
    //TODO: Login de Admin
}