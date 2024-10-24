package com.example.demo.repository;

import com.example.demo.entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Cliente findByCedula(Long cedula);
    boolean existsByCedula(Long cedula);

    @Query("SELECT COUNT(m) FROM Mascota m WHERE m.cliente.cedula = :cedula")
    long countMascotasByClienteId(@Param("cedula") Long cedula);

    @Query("SELECT c FROM Cliente c WHERE SIZE(c.mascotas) > :numMascotas")
    List<Cliente> findClientesWithMoreThanNMascotas(@Param("numMascotas") int numMascotas);

    @Query("SELECT c FROM Cliente c WHERE c.cedula BETWEEN :startCedula AND :endCedula")
    List<Cliente> findClientesByCedulaRange(@Param("startCedula") Long startCedula, @Param("endCedula") Long endCedula);

}