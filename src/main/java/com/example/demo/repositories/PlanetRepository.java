package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Planet;
import java.util.Optional;


public interface PlanetRepository extends JpaRepository<Planet, Integer> {

    Optional<Planet> findById(Integer id);
    
}
