package com.example.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MascotaRepositoryTest {
    
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Test
    public void MascotaRepository_findById_Mascota(){

    }

    @Test
    public void MascotaRepository_findAll_NoEmptyList(){

    }

    @Test
    public void MascotaRepository_add_Mascota(){
        //1. Arrange -> Preparar lo necesario para la prueba
        //2. Act -> Ejecutar la prueba
        //3. Assert -> Verificar si el resultado es el esperado

    }

    @Test
    public void MascotaRepository_update_Mascota(){

    }

    @Test
    public void MascotaRepository_delete_Mascota(){
        
    }



}
