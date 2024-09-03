package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Especialidad;
import com.example.demo.repository.EspecialidadRepository;



@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional
    public void agregarEspecialidad(String nombre_espe){
      especialidadRepository.save(new Especialidad(nombre_espe));
    }

    @Transactional
    public void eliminarEspecialidad(String nombre_espe){
      especialidadRepository.delete(especialidadRepository.findyByNombre_especialidad(nombre_espe));
    }
}