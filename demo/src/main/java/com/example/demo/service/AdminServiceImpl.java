/*package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    MascotaRepository repoMascota;

    @Autowired
    AdminRepository repoAdmin;

    @Autowired
    ClienteRepository repoCliente;

    @Override
    public Mascota SearchPetById(Long id) {
        return repoMascota.findById(id);
    }

    @Override
    public Collection<Mascota> SearchAllPets() {
        return repoMascota.findAll();
    }

    @Override
    public Collection<Cliente> SearchAllClients(){
        return repoCliente.findAll();
    }
    
    @Override
    public Cliente SearchClientById(Long id){
        Cliente cliente = repoCliente.findById(id).get();
        return cliente;
    }
}
*/