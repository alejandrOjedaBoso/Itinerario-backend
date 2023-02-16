package com.example.feign.Profesor.aplication.port;

import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface GetProfesorPort {
    public ProfesorOutputDTO getProfesor(int id) throws Exception;
}
