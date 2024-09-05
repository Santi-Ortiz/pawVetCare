package com.example.demo.controller;

public class ClientUpdatingException extends RuntimeException{

    private Long cedula;

    public ClientUpdatingException(Long cedula) {
       this.cedula = cedula;
    }

    public Long getCedula(){
        return cedula;
    }

    public void setCedula(Long cedula){
        this.cedula = cedula;
    }
    
}
