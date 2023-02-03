package com.example.EJ31.Student_Asignatura.aplication.port;

import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.input.AsignaturaInputDTO;
import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;

public interface UpdateAsignaturaPort {
    public AsignaturaOutputDTO updateAsignatura(int id, AsignaturaInputDTO asignaturaInputDTO) throws Exception;
}
