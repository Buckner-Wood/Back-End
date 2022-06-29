package com.javadevjournal.springbooth2.repository;

import com.javadevjournal.springbooth2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository < Employee, Integer > {
    
}
