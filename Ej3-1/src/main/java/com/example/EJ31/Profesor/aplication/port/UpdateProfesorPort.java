package com.example.EJ31.Profesor.aplication.port;

import com.example.EJ31.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface UpdateProfesorPort {
    public ProfesorOutputDTO updateProfesor(int id, ProfesorInputDTO profesorInputDTO) throws Exception;
}
