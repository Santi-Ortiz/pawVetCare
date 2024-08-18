package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cliente;
import java.util.*;

@Repository
public class ClienteRepository {

    private Map<Long, Cliente> data = new HashMap<>();

    public ClienteRepository() {
        data.put(12L, new Cliente(123456, "Juan Pérez", "juan.perez@example.com", 3001234567L));
    }


    public Collection<Cliente> findAll() {
        return data.values();
    }

	public Cliente findById(Long id) {
		return data.get(id);
	}

    public Cliente add (Cliente cliente) {
        return data.put(cliente.getId(), cliente);
    }

    public Cliente delete (Cliente cliente) {
        return data.remove(cliente.getId());
    }
}
