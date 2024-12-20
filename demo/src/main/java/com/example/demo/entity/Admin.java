package com.example.demo.entity;

import org.apache.xmlbeans.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="adm")
public class Admin {
    
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String contrasena;

    public Admin(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

}
