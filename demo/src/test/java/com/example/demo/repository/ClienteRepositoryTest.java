package com.example.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteRepositoryTest {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void ClienteRepository_findById_Cliente(){

    }

    @Test
    public void ClienteRepository_findAll_NoEmptyList(){

    }

    @Test
    public void ClienteRepository_add_Cliente(){

    }
    
    @Test
    public void ClienteRepository_update_Cliente(){

    }

}
