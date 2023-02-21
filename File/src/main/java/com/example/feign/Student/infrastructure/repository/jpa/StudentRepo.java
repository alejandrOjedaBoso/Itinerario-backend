package com.example.feign.Student.infrastructure.repository.jpa;

import com.example.feign.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
