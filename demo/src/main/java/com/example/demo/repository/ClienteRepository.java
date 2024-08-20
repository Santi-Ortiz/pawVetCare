package com.example.demo.repository;

//import org.springframework.stereotype.Repository;
import com.example.demo.entity.Cliente;
//import com.example.demo.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.*;

/**
 * ClienteRepository
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{}