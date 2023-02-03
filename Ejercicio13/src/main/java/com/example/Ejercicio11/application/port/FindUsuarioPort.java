package com.example.Ejercicio11.application.port;

import com.example.Ejercicio11.infrastucture.controller.dto.output.PersonaOutputDTO;
import java.util.ArrayList;
import java.util.List;

public interface FindUsuarioPort {
    public List<PersonaOutputDTO> todasPersonas() throws Exception;
    public PersonaOutputDTO buscarPorId(int id) throws Exception;
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre) throws Exception;
}
