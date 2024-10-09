package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.repository.TratamientoRepository;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository repoTratamientoRepository;

    @Transactional
    public void agregarTratamiento (Date fecha, Veterinario veterinario, Mascota mascota, List<Medicamento> medicamentos){
        repoTratamientoRepository.save(new Tratamiento(fecha, veterinario, mascota));
    }

    @Transactional
    public void eliminarTratamiento(Long id){
      repoTratamientoRepository.delete(repoTratamientoRepository.findById(id).get());
    }
}