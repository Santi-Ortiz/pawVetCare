package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteRepositoryTest {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    void init(){

        clienteRepository.save(new Cliente(1971408607L,"Harrison Moreno","in.lobortis@protonmail.couk",336215273L));
        clienteRepository.save(new Cliente(1963427700L,"Dora Shields","id@protonmail.com",376298968L));
        clienteRepository.save(new Cliente(1873486866L,"Lareina Roy","velit.dui.semper@outlook.org",341482251L));
        clienteRepository.save(new Cliente(1410113199L,"Drake Glenn","in.at@icloud.ca",333104316L));

        mascotaRepository.save(new Mascota("Alejandra","Chihuahua",9,5.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",true,clienteRepository.findByCedula(336215273L)));
        mascotaRepository.save(new Mascota("Santiago","Golden",9,20.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(376298968L)));
        mascotaRepository.save(new Mascota("Nicolas","Husky",6,30.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(341482251L)));
        mascotaRepository.save(new Mascota("Honey","BordeCollie",8,4.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findByCedula(333104316L)));
    } 

    @Test
    public void ClienteRepository_findById_Cliente(){

        Cliente cliente = new Cliente(1032876577L,"Harrison Moreno", "hola@example.com", 123456789L);

        clienteRepository.save(cliente);
        clienteRepository.findById(cliente.getId()).get();

        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(cliente.getCedula()).isEqualTo(1032876577L);

    }

    @Test
    public void ClienteRepository_findAll_NoEmptyList(){

        Cliente cliente1 = new Cliente(1598765475L, "Martin Garrix", "pepepro@example.com", 455555546L);
        Cliente cliente2 = new Cliente(465789633L, "Juan Luis Guerra", "avispas@example.com", 123456789L);

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        List<Cliente> clientes = clienteRepository.findAll();

        Assertions.assertThat(clientes).isNotEmpty();
        Assertions.assertThat(clientes.size()).isEqualTo(2);
        Assertions.assertThat(clientes.size()).isGreaterThan(0);
    }

    @Test
    public void ClienteRepository_add_Cliente(){
        
        Cliente cliente = new Cliente(654320987L, "Carlos Vives", "carlitos@vives.com", 123456789L);

        clienteRepository.save(cliente);

        Assertions.assertThat(cliente).isNotNull();
        Assertions.assertThat(cliente.getCedula()).isEqualTo(654320987L);
        Assertions.assertThat(cliente.getNombre()).isEqualTo("Carlos Vives");
    }
    
    @Test
    public void ClienteRepository_update_Cliente(){

        Cliente cliente = new Cliente(658944567L, "Juanes", "camisa@negra.com", 123456789L);
        clienteRepository.save(cliente);

        cliente.setNombre("Farruko");
        cliente.setCedula(123456788L);
        clienteRepository.save(cliente);

        Assertions.assertThat(cliente.getNombre()).isEqualTo("Farruko");
        Assertions.assertThat(cliente.getCedula()).isEqualTo(123456788L);
    }

    @Test
    public void ClienteRepository_delete(){

        Cliente cliente = new Cliente(532587633L, "Oliver Heldens", "hello@example.com", 123456789L);
        clienteRepository.save(cliente);

        clienteRepository.delete(cliente);
        Optional<Cliente> clienteEliminado = clienteRepository.findById(cliente.getId());

        Assertions.assertThat(clienteEliminado).isEmpty();
        Assertions.assertThat(clienteEliminado).isNotPresent();

    }

    @Test
    public void ClienteRepository_asignarMascotaCliente_Cliente(){
        
        Cliente cliente = new Cliente(148963577L, "Pedro Capó", "calma@example.com", 123456789L);
        Mascota mascota1 = new Mascota("Santiago","Golden",9,20.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true, null);
        Mascota mascota2 = new Mascota("Alejandra","Chihuahua",9,5.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",true, null);
        List<Mascota> mascotas = List.of(mascota1, mascota2);
        clienteRepository.save(cliente);

        cliente.setMascotas(mascotas);

        Assertions.assertThat(cliente.getMascotas()).isNotEmpty();
        Assertions.assertThat(cliente.getMascotas().size()).isEqualTo(2);
        Assertions.assertThat(cliente.getMascotas().size()).isGreaterThan(0);
    }

}
