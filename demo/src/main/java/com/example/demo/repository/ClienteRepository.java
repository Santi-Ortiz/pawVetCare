package com.example.demo.repository;

import com.example.demo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    public Cliente findByCedula(Long cedula);
    boolean existsByCedula(Long cedula);
}