package com.example.demo.services;


import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Climate;
import com.example.demo.entities.Planet;
import com.example.demo.repositories.ClimateRepository;
import com.example.demo.repositories.PlanetRepository;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class ClimateService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private ClimateRepository climateRepository;

    @Autowired
    private PlanetService planetService;

    public List<Climate> generateAllClimateData(){
        
        List<Climate> listClimate =  new ArrayList<>();

        LocalDate date = LocalDate.of(2023, 1, 1);
        for (int i = 0; i < 3650; i++) { 
            Climate climate = this.determinateClimateByDate(date);
            listClimate .add(climate);
            date = date.plusDays(1);
        }

        climateRepository.saveAll(listClimate);
        return listClimate;

    }

    public Climate determinateClimateByDate(LocalDate date) {

        if (planetService.areAlined(date)) {
            return new Climate("sequía");
        } else if (planetService.sunIsInTriangle(date)) {
            return new Climate("lluvia");
        } else {
            return new Climate("condiciones óptimas");
        }

    }

    
}
