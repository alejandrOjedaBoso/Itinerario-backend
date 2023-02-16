package com.example.feign.Profesor.aplication.port;

import com.example.feign.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface UpdateProfesorPort {
    public ProfesorOutputDTO updateProfesor(int id, ProfesorInputDTO profesorInputDTO) throws Exception;
}
