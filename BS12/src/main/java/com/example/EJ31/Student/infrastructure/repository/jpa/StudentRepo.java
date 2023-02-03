package com.example.EJ31.Student.infrastructure.repository.jpa;

import com.example.EJ31.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
