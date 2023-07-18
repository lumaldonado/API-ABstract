package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Weather;
import com.example.demo.repositories.WeatherRepository;
import com.example.demo.services.WeatherService;
import com.example.demo.services.PlanetService;

@RestController
@RequestMapping("/climate")
public class WeatherController {

    @Autowired
    WeatherService service;

    @Autowired
    PlanetService servicePlanet;

    @Autowired
    WeatherRepository repository;


    @GetMapping("/all")
    public List<Weather> obtenerCondicionesClimaticas() {
        return service.generateAllClimateData();
    }

    @GetMapping("/{fecha}")
    public Weather obtenerClimaPorFecha(@PathVariable LocalDate fecha) {
        return service.findByDate(fecha);
    }

    @GetMapping("/wetherCondition")
    public List<Weather> obtenerClimaPorClima(@RequestParam String climate) {
        return repository.findByWeatherCondition(climate);
    }

    @GetMapping("/wetherCondition/numberOfDays")
    public Integer getHowManyDaysPerWeatherCondition(@RequestParam String climate) {
        return service.howManyDaysPerWeatherCondition(climate);
    }

    
}
