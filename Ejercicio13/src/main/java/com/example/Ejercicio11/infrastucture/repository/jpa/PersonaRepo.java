package com.example.Ejercicio11.infrastucture.repository.jpa;


import com.example.Ejercicio11.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonaRepo extends JpaRepository<Persona,Integer> {
}
