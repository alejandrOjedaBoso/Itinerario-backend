package com.example.EJ31.Student.aplication;

import com.example.EJ31.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.EJ31.Student.aplication.port.AddStudentPort;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
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
