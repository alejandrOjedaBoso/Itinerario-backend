package com.example.Ejercicio11.application;

import com.example.Ejercicio11.application.port.AddUsuarioPort;
import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.Ejercicio11.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.Ejercicio11.domain.Persona;
import com.example.Ejercicio11.infrastucture.repository.jpa.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUsuarioUseCase implements AddUsuarioPort {

    @Autowired
    PersonaRepo personaRepo;
    @Override
    public PersonaOutputDTO aniadirUsuario(PersonaInputDTO persona) throws Exception {
        if(persona.getUsuario().length()<6 || persona.getUsuario().length()>10){
            throw new Exception("El usuario debe estar entre 6 y 10 caracteres");
        }
        else {
            Persona entidad=new Persona(persona);
            personaRepo.save(entidad);
            return new PersonaOutputDTO(entidad);
        }
    }
}
