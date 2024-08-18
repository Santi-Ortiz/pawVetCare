package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
public interface AdminService {

    public Mascota SearchPetById(Long id);
 
    public Collection<Mascota> SearchAllPets();

    public Collection<Cliente> SearchAllClients();

    public Cliente SearchClientById(Long id);
}