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
    public String errorCliente(Model model, NotClientFoundException ex){
        model.addAttribute("id", ex.getId());
        return "errorClienteNoEncontrado";
    }

    @ExceptionHandler(ClientExistingException.class)
    public String errorClienteExistente(Model model, ClientExistingException ex){
        model.addAttribute("cedula", ex.getCedula());
        return "errorClienteExistente";
    }

    @ExceptionHandler(ClientUpdatingException.class)
    public String errorClienteActualizado(Model model, ClientUpdatingException ex){
        model.addAttribute("cedula", ex.getCedula());
        return "errorClienteActualizado";
    }

    @ExceptionHandler(NotClientIdExistInPet.class)
    public String errorClienteIdEnMascota(Model model, NotClientIdExistInPet ex){
        model.addAttribute("cedula", ex.getCedula());
        return "errorClienteIdNoExistenteMascota";  
    }
}
