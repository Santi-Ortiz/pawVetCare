package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(NotPetFoundException.class)
    public String errorMascota(Model model, NotPetFoundException ex){
        model.addAttribute("id", ex.getId());
        return "errorMascotaNoEncontrada";
    }

    @ExceptionHandler(NotClientFoundException.class)
    public String errorCliente(Model model, NotClientFoundException exep){
        model.addAttribute("id", exep.getId());
        return "errorClienteNoEncontrado";
    }
}
