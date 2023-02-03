package com.example.Ejercicio11;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonaRepo extends JpaRepository<Persona,Integer> {
}
