package com.example.EJ31.Persona.infrastucture.repository.jpa;


import com.example.EJ31.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonaRepo extends JpaRepository<Persona,Integer> {
    List<Persona> findByName(String name);
}
