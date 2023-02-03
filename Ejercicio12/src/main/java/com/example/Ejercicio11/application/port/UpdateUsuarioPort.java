package com.example.Ejercicio11.application.port;

import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.Ejercicio11.infrastucture.controller.dto.output.PersonaOutputDTO;


public interface UpdateUsuarioPort {
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaDTO) throws Exception;
}
