package com.example.EJ31.Student_Asignatura.aplication;

import com.example.EJ31.Student_Asignatura.aplication.port.UpdateAsignaturaPort;
import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.input.AsignaturaInputDTO;
import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;
import com.example.EJ31.Student_Asignatura.infrastructure.repository.jpa.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAsignaturaUseCase implements UpdateAsignaturaPort {
    @Autowired
    AsignaturaRepo asignaturaRepo;

    @Override
    public AsignaturaOutputDTO updateAsignatura(int id, AsignaturaInputDTO asignaturaInputDTO) throws Exception {
        Student_Asignatura student_asignatura= asignaturaRepo.findById(id).orElseThrow(() ->new Exception("El id no se ha encontrado "+id));

        student_asignatura.setId_study(id);
        student_asignatura.setAsignatura(asignaturaInputDTO.getAsignatura());
        student_asignatura.setComment(asignaturaInputDTO.getComment());
        student_asignatura.setFinish_date(asignaturaInputDTO.getFinish_date());
        student_asignatura.setInitial_date(asignaturaInputDTO.getInitial_date());

        asignaturaRepo.save(student_asignatura);
        return new AsignaturaOutputDTO(student_asignatura);
    }
}
