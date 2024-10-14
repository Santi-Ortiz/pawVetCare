package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.VeterinarioRepository;

import java.util.*;

@Service
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Transactional
    public Veterinario buscarVetPorCedula(Long cedula){
      return veterinarioRepository.findByCedula(cedula);
    }

    @Transactional
    public Veterinario buscarVet(Long id){
      return veterinarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public Veterinario agregarVet(Veterinario veterinario){
      if(veterinarioRepository.findByCedula(veterinario.getCedula()) == null){
        return veterinarioRepository.save(veterinario);
      } else{
        return new Veterinario();
      }
    }

    @Transactional
    public void actualizarVet(Veterinario veterinario){
      Veterinario vet = veterinarioRepository.findByCedula(veterinario.getCedula());
      if(vet != null && !vet.getCedula().equals(veterinario.getCedula())){
        System.out.println("No se puede actualizar el veterinario");
      } else{
        veterinarioRepository.save(veterinario);
      }
    }

    public Collection<Veterinario> mostrarTodos(){
      return veterinarioRepository.findAll();
    }

    @Transactional
    public void eliminarVet(Long cedula){
      veterinarioRepository.delete(veterinarioRepository.findByCedula(cedula));
    }
}