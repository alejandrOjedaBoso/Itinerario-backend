package com.example.EJ31.Student_Asignatura.aplication.port;

import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;

import java.util.List;

public interface GetAsignaturaPort {
    public AsignaturaOutputDTO getAsignatura(int id) throws Exception;
    public List<AsignaturaOutputDTO> getAsignaturaStudent(int id) throws Exception;
}
