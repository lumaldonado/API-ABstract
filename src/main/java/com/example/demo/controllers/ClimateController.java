package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Climate;
import com.example.demo.services.ClimateService;

@RestController
@RequestMapping("/climate")
public class ClimateController {

    @Autowired
    ClimateService service;

    @GetMapping("/all")
    public List<Climate> obtenerCondicionesClimaticas() {
        return service.generateAllClimateData();
    }

    @GetMapping("/{fecha}")
    public Climate obtenerClimaPorFecha(@PathVariable LocalDate fecha) {
        return service.determinateClimateByDate(fecha);
    }

    
}
