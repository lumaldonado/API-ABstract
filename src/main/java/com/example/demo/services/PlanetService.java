package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

import com.example.demo.entities.Planet;

public class PlanetService {

    Planet ferengi = new Planet("Farengi", 1, 500);
    Planet betasoide = new Planet("Betasoide", 3, 2000);
    Planet vulcano = new Planet("Vulcano", 1, 1000);

    public boolean areAlined(LocalDate date) {
        List<Long> angleList = this.getAngles(date);

        if (angleList.get(0).equals(angleList.get(1)) && angleList.get(0).equals(angleList.get(2))) {
            return true;
        } else {
            return false;
        }

    }

    public boolean sunIsInTriangle(LocalDate date) {
        List<Long> angleList = this.getAngles(date);
        long X = 0;
        long Y = 0;
        long p1x = angleList.get(0);
        long p2x = angleList.get(1);
        long p3x = angleList.get(2);

        double totalArea = Math.abs((p2x - p3x) * (0 - p3x) + (p3x - p2x) * (Y - p3x));
        double area1 = Math.abs((p2x - p3x) * (X - p3x) + (p3x - p2x) * (Y - p3x));
        double area2 = Math.abs((p3x - 0) * (X - p3x) + (0 - p3x) * (Y - p3x));
        double area3 = Math.abs((0 - p2x) * (X - 0) + (p2x - 0) * (Y - 0));
        
        return area1 + area2 + area3 == totalArea;
    }

    public List<Long> getAngles(LocalDate date) {

        LocalDate initialDate = LocalDate.of(2023, 1, 1);
        long days = DAYS.between(initialDate, date);
        List<Long> angleList = new ArrayList<>();

        long ferengiAngle = ferengi.getAngularSpeed() * days;
        long betasoideAngle = betasoide.getAngularSpeed() * days;
        long vulcanoAngle = vulcano.getAngularSpeed() * days;

        angleList.add(ferengiAngle);
        angleList.add(betasoideAngle);
        angleList.add(vulcanoAngle);

        return angleList;

    }

}
