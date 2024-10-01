package com.example.demo.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Medicamento;

@Service
public class ExcelReaderService {
    
    public void readExcelFile(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        default:
                            System.out.print(cell + "\t\t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public List<Medicamento> obtenerInfoMedicamento(InputStream InputStream) {
        List<Medicamento> medicamentos = new ArrayList<>();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(InputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            int rowIndex = 0;
            for(Row row : sheet){
                if(rowIndex != 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                int cellIndex = 0;
                Medicamento medicamento = new Medicamento();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0 -> medicamento.setNombre(cell.getStringCellValue());
                        case 1 -> medicamento.setPrecio_venta(cell.getNumericCellValue());
                        case 2 -> medicamento.setPrecio_compra(cell.getNumericCellValue());
                        case 3 -> medicamento.setUnidades_disponibles((int) cell.getNumericCellValue());
                        case 4 -> medicamento.setUnidades_vendidas((int) cell.getNumericCellValue());
                        default -> {}
                    }
                    cellIndex++;
                }
                medicamentos.add(medicamento);

            }
            return medicamentos; 
        } catch (IOException e) {
            e.getStackTrace();
        }
        return medicamentos;
    }*/

    public List<Medicamento> obtenerInfoMedicamento(String filePath) {
        List<Medicamento> medicamentos = new ArrayList<>();

        try{
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            int rowIndex = 0;
            for(Row row : sheet){
                if(rowIndex != 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                int cellIndex = 1;
                Medicamento medicamento = new Medicamento();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 1 -> medicamento.setNombre(cell.getStringCellValue());
                        case 2 -> medicamento.setPrecio_venta(cell.getNumericCellValue());
                        case 3 -> medicamento.setPrecio_compra(cell.getNumericCellValue());
                        case 4 -> medicamento.setUnidades_disponibles((int) cell.getNumericCellValue());
                        case 5 -> medicamento.setUnidades_vendidas((int) cell.getNumericCellValue());
                        default -> {}
                    }
                    cellIndex++;
                }
                medicamentos.add(medicamento);

            }
            return medicamentos; 
        } catch (IOException e) {
            e.getStackTrace();
        }
        return medicamentos;
    }

}

