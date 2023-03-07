package com.example.EJ31.Persona.aplication.port;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface FindUsuarioPort {
    public List<PersonaOutputDTO> todasPersonas(String outputType) throws Exception;
    public PersonaOutputDTO buscarPorId(int id,String outputType) throws Exception;
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre,String outputType) throws Exception;
    public List<Persona>  criteriaEj1(HashMap<String, Object> persona, String tipoFecha,String ordenar,int tamano,int numPag);
}
