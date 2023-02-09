package com.example.feign.Student_Asignatura.aplication;

import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
import com.example.feign.Student_Asignatura.aplication.port.GetAsignaturaPort;
import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import com.example.feign.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;
import com.example.feign.Student_Asignatura.infrastructure.repository.jpa.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAsignaturaUseCase implements GetAsignaturaPort {
    @Autowired
    AsignaturaRepo asignaturaRepo;
    @Autowired
    StudentRepo studentRepo;

    @Override
    public AsignaturaOutputDTO getAsignatura(int id) throws Exception {
        Student_Asignatura student_asignatura= asignaturaRepo.findById(id).orElseThrow(()->new Exception("El id no se a encontrado"));

        return new AsignaturaOutputDTO(student_asignatura);
    }

    @Override
    public List<AsignaturaOutputDTO> getAsignaturaStudent(int id) throws Exception {
        //Devuelve las asignaturas en las cuales esta apuntado un estudiante
        Student student=studentRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado estudiante"));
        List<Student_Asignatura> asignaturas=student.getStudent_asignatura();
        List<AsignaturaOutputDTO> asignaturasOutput=new ArrayList<AsignaturaOutputDTO>();
        for (Student_Asignatura i: asignaturas) {
            asignaturasOutput.add(new AsignaturaOutputDTO(i));
        }
        return asignaturasOutput;
    }
}
