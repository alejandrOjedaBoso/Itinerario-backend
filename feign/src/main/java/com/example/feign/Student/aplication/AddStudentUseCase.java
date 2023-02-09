package com.example.feign.Student.aplication;

import com.example.feign.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.feign.Student.aplication.port.AddStudentPort;
import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddStudentUseCase implements AddStudentPort {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    PersonaRepo personaRepo;


    @Override
    public Student addStudent(Student student) throws Exception {
        studentRepo.save(student);
        return student;
    }
}
