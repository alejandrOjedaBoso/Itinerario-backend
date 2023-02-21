package com.example.feign.Student_Asignatura.aplication;

import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
import com.example.feign.Student_Asignatura.aplication.port.DeleteAsignaturaPort;
import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import com.example.feign.Student_Asignatura.infrastructure.repository.jpa.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAsignaturaUseCase implements DeleteAsignaturaPort {
    @Autowired
    AsignaturaRepo asignaturaRepo;
    @Autowired
    StudentRepo studentRepo;
    @Override
    public void deleteAsignatura(int id) throws Exception {
        Student_Asignatura student_asignatura=asignaturaRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado el id: "+id));
        boolean borrar=true;
        for (Student s:studentRepo.findAll()) {
            if(s.getStudent_asignatura().contains(student_asignatura)){
                borrar=false;
            }
        }
        if (borrar) {
            asignaturaRepo.delete(student_asignatura);
        }
    }
}
