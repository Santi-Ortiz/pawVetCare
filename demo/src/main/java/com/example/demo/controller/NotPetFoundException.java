package com.example.demo.controller;

public class NotPetFoundException extends RuntimeException {

    private Long id;

    public NotPetFoundException(Long id) {
       this.id = id;
    }

    public NotPetFoundException(String nombreMascota) {
        //TODO Auto-generated constructor stub
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
}
