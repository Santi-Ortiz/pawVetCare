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
public class MascotaRepositoryTest {
    
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
    public void MascotaRepository_findById_Mascota(){

        Mascota mascota = new Mascota("Tobias", "Pastor Alemán", 9,5.5F, "Leptospirosis", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg", true, null);

        mascotaRepository.save(mascota);
        mascotaRepository.findById(mascota.getId()).get();

        Assertions.assertThat(mascota).isNotNull();
    }

    @Test
    public void MascotaRepository_findAll_NoEmptyList(){

        Mascota mascota1 = new Mascota("Tobias", "Pastor Alemán", 9,5.5F, "Leptospirosis", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg", true, null);
        Mascota mascota2 = new Mascota("Paco", "Labrador", 9,5.5F, "Insuficiencia Renal", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg", true, null);

        mascotaRepository.save(mascota1);
        mascotaRepository.save(mascota2);
        List<Mascota> mascotas = mascotaRepository.findAll();

        Assertions.assertThat(mascotas).isNotEmpty();
        Assertions.assertThat(mascotas.size()).isEqualTo(2);
        Assertions.assertThat(mascotas.size()).isGreaterThan(0);
    }

    @Test
    public void MascotaRepository_add_Mascota(){
         // 1. Arrange -> Preparar lo necesario para la prueba
         Mascota mascota = new Mascota("Luna", "Beagle", 4, 10.0F, "Saludable", "https://example.com/luna.jpg", true, null);

         // 2. Act -> Ejecutar la prueba
         Mascota mascotaGuardada = mascotaRepository.save(mascota);
 
         // 3. Assert -> Verificar si el resultado es el esperado
         Assertions.assertThat(mascotaGuardada).isNotNull();
         Assertions.assertThat(mascotaGuardada.getId()).isNotNull();
         Assertions.assertThat(mascotaGuardada.getNombre()).isEqualTo("Luna");

    }

    @Test
    public void MascotaRepository_update_Mascota(){
        Mascota mascota = new Mascota("Luna", "Beagle", 4, 10.0F, "Saludable", "https://example.com/luna.jpg", true, null);
        Mascota mascotaGuardada = mascotaRepository.save(mascota);

        mascotaGuardada.setNombre("Luna Actualizada");
        Mascota mascotaActualizada = mascotaRepository.save(mascotaGuardada);

        Assertions.assertThat(mascotaActualizada.getNombre()).isEqualTo("Luna Actualizada");
    }

    @Test
    public void MascotaRepository_delete(){
        Mascota mascota = new Mascota("Luna", "Beagle", 4, 10.0F, "Saludable", "https://example.com/luna.jpg", true, null);
        Mascota mascotaGuardada = mascotaRepository.save(mascota);

        mascotaRepository.delete(mascotaGuardada);
        Optional<Mascota> mascotaEliminada = mascotaRepository.findById(mascotaGuardada.getId());

        Assertions.assertThat(mascotaEliminada).isEmpty();
        Assertions.assertThat(mascotaEliminada).isNotPresent();
    }

    // Consultas personalizadas

    @Test
    public void MascotaRepository_encontrarMascotasPorNombre_NotEmptyList(){
        Mascota mascota = new Mascota("Luna", "Beagle", 4, 10.0F, "Saludable", "https://example.com/luna.jpg", true, null);
        mascotaRepository.save(mascota);

        List<Mascota> mascotas = mascotaRepository.findAllByNombre("Luna");

        Assertions.assertThat(mascotas).isNotEmpty();
        Assertions.assertThat(mascotas.size()).isEqualTo(1);
        Assertions.assertThat(mascotas.get(0).getNombre()).isEqualTo("Luna");
    }

    @Test
    public void MascotaRepository_encontrarMascotasPorEstado_NotEmptyList(){
        Mascota mascota = new Mascota("Luna", "Beagle", 4, 10.0F, "Saludable", "https://example.com/luna.jpg", true, null);
        mascotaRepository.save(mascota);

        List<Mascota> mascotas = mascotaRepository.findAllByEstado(true);

        Assertions.assertThat(mascotas).isNotEmpty();
        Assertions.assertThat(mascotas.size()).isGreaterThan(0);
        Assertions.assertThat(mascotas.get(0).getEstado()).isEqualTo(true);
    }

    @Test
    public void MascotaRepository_encontrarMascotasPorEdadBetween_NotEmptyList(){
        Mascota mascota = new Mascota("Luna", "Beagle", 4, 10.0F, "Saludable", "https://example.com/luna.jpg", true, null);
        mascotaRepository.save(mascota);

        List<Mascota> mascotas = mascotaRepository.findAllByEdadBetween(3, 5);

        Assertions.assertThat(mascotas).isNotEmpty();
        Assertions.assertThat(mascotas.size()).isGreaterThan(0);
        Assertions.assertThat(mascotas.get(0).getEdad()).isBetween(3, 5);
    }

}
