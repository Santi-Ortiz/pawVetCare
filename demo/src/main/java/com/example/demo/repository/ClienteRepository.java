package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;

import java.util.*;

@Repository
public class ClienteRepository {

    private Map<Long, Cliente> data = new HashMap<>();
    private Map<Integer, Cliente> dataByCedula = new HashMap<>();

    public ClienteRepository() {
        Mascota mascota1 = new Mascota(1L, "Firulais", "Labrador", 5, 20F, "Viruela", "",true, 1L);
        Cliente cliente1 = new Cliente(1L, 123456, "Juan Pérez", "juan.perez@example.com", 3001234567L, Map.of(1L, mascota1));
        data.put(cliente1.getId(), cliente1);
        dataByCedula.put(cliente1.getCedula(), cliente1); // Añadir al mapa por cédula
    }

    public Collection<Cliente> findAll() {
        return data.values();
    }

	public Cliente findById(Long id) {
		return data.get(id);
	}

    public Cliente findByCedula(Integer cedula) {
        return dataByCedula.get(cedula);
    }

    public Cliente add (Cliente cliente) {
        return data.put(cliente.getId(), cliente);
    }

    public Cliente delete (Cliente cliente) {
        return data.remove(cliente.getId());
    }

    public Collection<Mascota> findAllPets() {
        return data.values().stream().map(Cliente::getMascotas).flatMap(m -> m.values().stream()).toList();
    }

    public Mascota findPetById(Long id) {
        Mascota mascota = new Mascota(id, null, null, null, null, null, null, null, id);
        return mascota;
    }
    
}
