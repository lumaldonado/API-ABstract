package com.example.demo.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Climate;


public interface ClimateRepository  extends JpaRepository<Climate, Integer>{

    Optional<Climate> findById(Integer id);
    
}
