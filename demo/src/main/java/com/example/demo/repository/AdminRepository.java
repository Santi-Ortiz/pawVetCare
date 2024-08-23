package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;

//import java.util.*;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{} 
/*public class AdminRepository{


    private Map<String, String> data = new HashMap<>();

    public AdminRepository() {
        data.put("admin", "admin");
    }




}*/
