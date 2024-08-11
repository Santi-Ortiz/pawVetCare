package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Mascota;
import java.util.*;

@Repository
public class MascotaRepository  {

    private Map<Integer, Mascota> data = new HashMap<>();

    public MascotaRepository(){
        data.put(1, new Mascota("Firulais", "Pastor Aleman", 5, 20.0f, "Moquillo", "https://i.pinimg.com/236x/e0/19/17/e0191785c29396e42bccc19c6c3db098.jpg", true));
        data.put(2, new Mascota("Rex", "Pitbull", 3, 15.0f, "Rabia", "foto2", true));
        data.put(3, new Mascota("Boby", "Chihuahua", 2, 5.0f, "Gripe", "foto3", true));
    }

    public Mascota findById(int id){
        return data.get(id);
    }

    public Collection<Mascota> findAll(){
        return data.values();
    }
}