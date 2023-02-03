package com.example.EJ31.Profesor.aplication.port;

import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface GetProfesorPort {
    public ProfesorOutputDTO getProfesor(int id) throws Exception;
}
