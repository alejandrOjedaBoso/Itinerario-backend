package com.example.feign.Persona.aplication;

import com.example.feign.Persona.aplication.port.AddUsuarioPort;
import com.example.feign.Persona.domain.Persona;
import com.example.feign.Persona.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.feign.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.feign.Persona.infrastucture.repository.jpa.PersonaRepo;
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
