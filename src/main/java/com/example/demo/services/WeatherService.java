package com.example.demo.services;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Weather;
import com.example.demo.repositories.WeatherRepository;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository climateRepository;

    @Autowired
    private PlanetService planetService;

    public List<Weather> generateAllClimateData() {

        List<Weather> listClimate = new ArrayList<>();

        LocalDate date = LocalDate.of(2023, 1, 1);
        for (int i = 0; i < 3650; i++) {
            Weather climate = planetService.calculateWeatherCondition(date);
            listClimate.add(climate);
            date = date.plusDays(1);
        }

        climateRepository.saveAll(listClimate);
        return listClimate;

    }

    public Weather findByDate(LocalDate date) {

        Weather weather = climateRepository.findByDate(date);
        if (weather == null) {
            return null;
        }
        return weather;

    }

    public Integer howManyDaysPerWeatherCondition(String weatherCondition) {

        Integer weatherConditionDays = climateRepository.findByWeatherCondition(weatherCondition).size();
        if (weatherConditionDays.equals(0)) {
            return null;
        }
        return weatherConditionDays;

    }

}
