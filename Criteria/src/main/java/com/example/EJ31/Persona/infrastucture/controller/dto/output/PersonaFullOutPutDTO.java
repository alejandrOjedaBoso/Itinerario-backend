package com.example.EJ31.Persona.infrastucture.controller.dto.output;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.domain.ePersona;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.EJ31.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import lombok.Data;

@Data
public class PersonaFullOutPutDTO extends PersonaOutputDTO{
    ProfesorOutputDTO profesor;
    StudentOutputDTO student;

    public PersonaFullOutPutDTO(Persona persona,ePersona tipo) throws Exception {
        super(persona);

        //Depende del tipo de persona se rellenara un campo u otro
        if(tipo==ePersona.ESTUDIANTE) {
            setStudent(new StudentOutputDTO(persona.getStudent()));
        }else if(tipo==ePersona.PROFESOR) {
            setProfesor(new ProfesorOutputDTO(persona.getProfesor()));
        }
    }

}
