package com.example.EJ31.Student_Asignatura.infrastructure.repository.jpa;

import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepo extends JpaRepository<Student_Asignatura,Integer> {
}
