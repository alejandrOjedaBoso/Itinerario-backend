package com.example.feign.Persona.infrastucture.controller.dto.output;

import com.example.feign.Persona.domain.Persona;
import com.example.feign.Persona.domain.ePersona;
import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.feign.Student.infrastructure.controller.dto.output.StudentOutputDTO;
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
