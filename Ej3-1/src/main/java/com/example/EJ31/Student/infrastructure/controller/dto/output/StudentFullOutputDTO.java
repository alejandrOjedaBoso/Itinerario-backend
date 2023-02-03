package com.example.EJ31.Student.infrastructure.controller.dto.output;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Student.domain.Student;
import lombok.Data;

@Data
public class StudentFullOutputDTO extends StudentOutputDTO{
    private Persona persona;

    public StudentFullOutputDTO(Student student,Persona persona) {
        super(student);
        setPersona(persona);
    }
}
