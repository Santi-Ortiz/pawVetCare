package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(Exception.class)
    public String error(Model model, NotPetFoundException ex){
        model.addAttribute("id", ex.getId());
        return "errorMascotaNoEncontrada";
    }
}
