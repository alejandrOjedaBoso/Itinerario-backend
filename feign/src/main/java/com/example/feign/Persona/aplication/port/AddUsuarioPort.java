package com.example.feign.Persona.aplication.port;

import com.example.feign.Persona.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.feign.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;

public interface AddUsuarioPort {
    public PersonaOutputDTO aniadirUsuario(PersonaInputDTO persona) throws Exception ;
}
