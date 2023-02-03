package com.example.EJ31.Persona.aplication.port;

import com.example.EJ31.Persona.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;

public interface AddUsuarioPort {
    public PersonaOutputDTO aniadirUsuario(PersonaInputDTO persona) throws Exception ;
}
