package com.example.demo.controller;

public class NotClientFoundException extends RuntimeException{

    private Long id;

    public NotClientFoundException(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
}
