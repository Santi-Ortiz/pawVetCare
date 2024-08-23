package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.ClienteRepository;
//import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.MascotaRepository;

@Service
public class AdminService {

    @Autowired
    private MascotaRepository repoMascota;

    /*@Autowired
    private AdminRepository repoAdmin;*/

    @Autowired
    private ClienteRepository repoCliente;

    
    public Mascota SearchPetById(Long id) {
        Mascota mascota = repoMascota.findById(id).get();
        return mascota;
    }

    public List<Mascota> SearchAllPets() {
        return repoMascota.findAll();
    }

    public List<Cliente> SearchAllClients(){
        return repoCliente.findAll();
    }
    
    public Cliente SearchClientById(Long id){
        Cliente cliente = repoCliente.findById(id).get();
        return cliente;
    }
}