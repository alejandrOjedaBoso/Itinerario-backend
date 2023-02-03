package com.example.EJ31.Student_Asignatura.aplication;

import com.example.EJ31.Student_Asignatura.aplication.port.AddAsignaturaPort;
import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.input.AsignaturaInputDTO;
import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;
import com.example.EJ31.Student_Asignatura.infrastructure.repository.jpa.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAsignaturaUseCase implements AddAsignaturaPort {
    @Autowired
    AsignaturaRepo asignaturaRepo;
    @Override
    public AsignaturaOutputDTO addAsignatura(AsignaturaInputDTO asignaturaInputDTO) {
        Student_Asignatura student_asignatura=new Student_Asignatura(asignaturaInputDTO);
        asignaturaRepo.save(student_asignatura);
        return new AsignaturaOutputDTO(student_asignatura);
    }
}
