package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;

public interface ClienteService {

    public Cliente SearchById(Long id);
 
    public Collection<Cliente> SearchAll();
    
    public Cliente crearCliente(Cliente cliente);
    
    public Cliente eliminarCliente(Cliente cliente);

    public Collection<Mascota> buscarMascotas();

    public Mascota buscarMascotaPorID(Long id);

    public void agregarMascota(Long cliente_id, Mascota mascota);

    public void eliminarMascota(Long cliente_id, Mascota mascota);

    public void add(Mascota cliente);
}
