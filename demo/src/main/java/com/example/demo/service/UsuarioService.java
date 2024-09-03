package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void agregarUsuario(String tipo_usuario){
        usuarioRepository.save(new Usuario(tipo_usuario));
    }

    @Transactional
    public void eliminarUsuario(String tipo_usuario){
        usuarioRepository.delete(usuarioRepository.findByTipoUsuario(tipo_usuario));
    }
}
