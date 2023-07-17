package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int angularSpeed;
    private int toSunDistance;

    public Planet(String name, int angularSpeed, int toSunDistance){
        this.name = name;
        this.angularSpeed = angularSpeed;
        this.toSunDistance = toSunDistance;
    }

    
}
