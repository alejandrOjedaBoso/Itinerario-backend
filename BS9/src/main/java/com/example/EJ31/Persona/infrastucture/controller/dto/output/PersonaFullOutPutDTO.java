package com.example.EJ31.Persona.infrastucture.controller.dto.output;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.EJ31.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import lombok.Data;

@Data
public class PersonaFullOutPutDTO extends PersonaOutputDTO{
    ProfesorOutputDTO profesorOutputDTO;
    StudentOutputDTO studentOutputDTO;

    public PersonaFullOutPutDTO(Persona persona,StudentOutputDTO studentOutputDTO) throws Exception {
        super(persona);
        setStudentOutputDTO(studentOutputDTO);
    }
    public PersonaFullOutPutDTO(Persona persona,ProfesorOutputDTO profesorOutputDTO) throws Exception {
        super(persona);
        setProfesorOutputDTO(profesorOutputDTO);
    }
}
