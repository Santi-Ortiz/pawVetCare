package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ExcelReaderService;


@Controller
@RequestMapping("/archivo")
public class ExcelController {
    
    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            try {
                ExcelReaderService excelReaderService = new ExcelReaderService();
                excelReaderService.readExcelFile(file.getOriginalFilename());
                return "Archivo subido correctamente";
            } catch (Exception e) {
                return "La subida del archivo ha fallado";
            }
        } else {
            return "El archivo está vacío";
        }
    }
}
