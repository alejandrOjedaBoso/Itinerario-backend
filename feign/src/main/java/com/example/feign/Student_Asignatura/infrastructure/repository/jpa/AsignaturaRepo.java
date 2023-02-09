package com.example.feign.Student_Asignatura.infrastructure.repository.jpa;

import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepo extends JpaRepository<Student_Asignatura,Integer> {
}
