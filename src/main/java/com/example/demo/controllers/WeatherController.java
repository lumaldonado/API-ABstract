package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Weather;
import com.example.demo.repositories.WeatherRepository;
import com.example.demo.services.WeatherService;
import com.example.demo.services.PlanetService;

@RestController
@RequestMapping("/weather")
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
    public ResponseEntity<?> obtenerClimaPorFecha(@PathVariable LocalDate fecha) {
        Weather weather = service.findByDate(fecha);
        if (weather == null) {
            return ResponseEntity.badRequest().body("There are no weather records for that specific date");
        }
        return ResponseEntity.ok(weather);
    }

    @GetMapping("/weatherCondition")
    public ResponseEntity<?> obtenerClimaPorClima(@RequestParam("weather") String weather) {
        List<Weather> weatherList = repository.findByWeatherCondition(weather);
        if (weatherList.size() == 0) {

            return ResponseEntity.badRequest().body("There are no records for that weather condition");
        }
        return ResponseEntity.ok(weatherList);
    }

    @GetMapping("/weatherCondition/numberOfDays")
    public ResponseEntity<?> getHowManyDaysPerWeatherCondition(@RequestParam("weather") String weather) {
        Integer daysPerWeatherCondition = service.howManyDaysPerWeatherCondition(weather);
        if(daysPerWeatherCondition == null){
             return ResponseEntity.badRequest().body("There are no records for that weather condition");
        }
        return ResponseEntity.ok(daysPerWeatherCondition);
    }

}
