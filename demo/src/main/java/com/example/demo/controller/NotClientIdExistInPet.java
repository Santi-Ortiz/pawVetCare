package com.example.demo.controller;

public class NotClientIdExistInPet extends RuntimeException{
    private Long cedula;

    public NotClientIdExistInPet(Long cedula) {
       this.cedula = cedula;
    }

    public Long getCedula(){
        return cedula;
    }

    public void setCedula(Long cedula){
        this.cedula = cedula;
    }
}
