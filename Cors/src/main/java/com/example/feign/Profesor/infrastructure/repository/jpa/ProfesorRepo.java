package com.example.feign.Profesor.infrastructure.repository.jpa;

import com.example.feign.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo extends JpaRepository<Profesor,Integer> {
}
