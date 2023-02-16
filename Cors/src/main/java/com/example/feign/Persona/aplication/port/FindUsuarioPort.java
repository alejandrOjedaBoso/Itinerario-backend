package com.example.feign.Persona.aplication.port;

import com.example.feign.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;

import java.util.ArrayList;
import java.util.List;

public interface FindUsuarioPort {
    public List<PersonaOutputDTO> todasPersonas(String outputType) throws Exception;
    public PersonaOutputDTO buscarPorId(int id,String outputType) throws Exception;
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre,String outputType) throws Exception;
}
