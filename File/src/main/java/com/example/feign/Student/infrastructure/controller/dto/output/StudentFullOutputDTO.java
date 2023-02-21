package com.example.feign.Student.infrastructure.controller.dto.output;

import com.example.feign.Persona.domain.Persona;
import com.example.feign.Student.domain.Student;
import lombok.Data;

@Data
public class StudentFullOutputDTO extends StudentOutputDTO{
    private Persona persona;

    public StudentFullOutputDTO(Student student,Persona persona) {
        super(student);
        setPersona(persona);
    }
}
