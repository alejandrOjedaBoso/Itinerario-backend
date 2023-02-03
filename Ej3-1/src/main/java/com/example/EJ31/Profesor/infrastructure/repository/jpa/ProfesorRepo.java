package com.example.EJ31.Profesor.infrastructure.repository.jpa;

import com.example.EJ31.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo extends JpaRepository<Profesor,Integer> {
}
