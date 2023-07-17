package com.example.demo.entities;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Climate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String climateCondition;

    public Climate(String climateCondition){
        this.climateCondition = climateCondition;
    }

    
}
