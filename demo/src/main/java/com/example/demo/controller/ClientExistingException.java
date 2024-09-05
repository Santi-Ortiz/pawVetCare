package com.example.demo.controller;

public class ClientExistingException extends RuntimeException {

    private Long cedula;

    public ClientExistingException(Long cedula) {
       this.cedula = cedula;
    }

    public Long getCedula(){
        return cedula;
    }

    public void setCedula(Long cedula){
        this.cedula = cedula;
    }
    
}
