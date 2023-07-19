package com.example.demo.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Weather;

import java.time.LocalDate;




public interface WeatherRepository  extends JpaRepository<Weather, Integer>{

    Optional<Weather> findById(Integer id);
    Weather findByDate(LocalDate date);
    List<Weather> findByWeatherCondition(String weatherCondition);
    
}
