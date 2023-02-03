package com.example.EJ31.Persona.aplication.port;

import com.example.EJ31.Persona.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;


public interface UpdateUsuarioPort {
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaDTO) throws Exception;
}
