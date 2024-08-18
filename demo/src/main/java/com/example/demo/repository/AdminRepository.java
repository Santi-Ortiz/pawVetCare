package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class AdminRepository {

    private Map<String, String> data = new HashMap<>();

    public AdminRepository() {
        data.put("admin", "admin");
    }




}
