package com.example.demo.entities;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String weatherCondition;


    public Weather(LocalDate date, String weatherCondition){
        this.date = date;
        this.weatherCondition = weatherCondition;
    }

    
}
