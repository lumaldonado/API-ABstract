package com.example.demo.services;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Weather;
import com.example.demo.entities.Planet;

@Service
public class PlanetService {

    Planet ferengi = new Planet("Farengi", 1, 500);
    Planet betasoide = new Planet("Betasoide", 3, 2000);
    Planet vulcano = new Planet("Vulcano", 5, 1000);

    public Weather calculateWeatherCondition(LocalDate date) {
        double ferengiPosition = calculatePlanetPosition(ferengi.getAngularSpeed(), ferengi.getToSunDistance(), date);
        double betasoidePosition = calculatePlanetPosition(betasoide.getAngularSpeed(), betasoide.getToSunDistance(), date);
        double vulcanoPosition = calculatePlanetPosition(vulcano.getAngularSpeed(), vulcano.getToSunDistance(), date);
        
        if (arePlanetsAligned(ferengiPosition, betasoidePosition, vulcanoPosition)) {
            return new Weather(date, "sequia");
        } else if (isSunInsideTriangle(ferengiPosition, betasoidePosition, vulcanoPosition)) {
            return new Weather(date, "condiciones optimas");
        } else {
            return new Weather(date, "lluvia");
        }
    }

    private double calculatePlanetPosition(double angularSpeed, double distance, LocalDate date) {
        double degrees = (angularSpeed * date.getDayOfYear()) % 360; 
        return Math.toRadians(degrees);
    }

    private boolean arePlanetsAligned(double ferengiPosition, double betasoidePosition, double vulcanoPosition) {
        double diff1 = Math.abs(ferengiPosition - betasoidePosition);
        double diff2 = Math.abs(betasoidePosition - vulcanoPosition);
        double diff3 = Math.abs(vulcanoPosition - ferengiPosition);
        return (diff1 <= 0.001 && diff2 <= 0.001 && diff3 <= 0.001);
    }

    private boolean isSunInsideTriangle(double ferengiPosition, double betasoidePosition, double vulcanoPosition) {
        double sunPosition = 0.0; 
        double deltaAngle1 = Math.abs(sunPosition - ferengiPosition);
        double deltaAngle2 = Math.abs(sunPosition - betasoidePosition);
        double deltaAngle3 = Math.abs(sunPosition - vulcanoPosition);
        double totalAngle = Math.abs(deltaAngle1 + deltaAngle2 + deltaAngle3);
        return (totalAngle >= 0.001 && totalAngle <= (2 * Math.PI - 0.001));
    }

   
    
}