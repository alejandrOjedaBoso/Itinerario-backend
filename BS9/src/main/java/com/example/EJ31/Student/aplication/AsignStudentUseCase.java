package com.example.EJ31.Student.aplication;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import com.example.EJ31.Student.aplication.port.AsignStudentPort;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import com.example.EJ31.Student_Asignatura.infrastructure.repository.jpa.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AsignStudentUseCase implements AsignStudentPort {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ProfesorRepo profesorRepo;
    @Autowired
    PersonaRepo personaRepo;
    @Autowired
    AsignaturaRepo asignaturaRepo;

    @Override
    public void asignPersonaId(int idStudent, int idPersona) throws Exception {
        Student student=studentRepo.findById(idStudent).orElseThrow(()->new Exception("No se ha encontrado el id: "+idStudent+" para el estudiante"));
        Persona persona=personaRepo.findById(idPersona).orElseThrow(()->new Exception("No se ha encontrado el id: "+idPersona+" para persona"));
        student.setPersona(persona);
        studentRepo.save(student);
    }

    @Override
    public void asignProfesorId(int idStudent, int idProfesor) throws Exception {
        Student student=studentRepo.findById(idStudent).orElseThrow(()->new Exception("No se ha encontrado el id: "+idStudent+" para el estudiante"));
        Profesor profesor=profesorRepo.findById(idProfesor).orElseThrow(()->new Exception("No se ha encontrado el id: "+idProfesor+" para el profesor"));
        student.setProfesor(profesor);
        studentRepo.save(student);
    }

    @Override
    public void asignAsig(int idStudent, Map<String, Integer> mapaAsig) throws Exception {
        Student_Asignatura student_asignatura=null;
        Student student=studentRepo.findById(idStudent).orElseThrow(()->new Exception(""));
        for (Integer idAsig: mapaAsig.values()) {
            student_asignatura=asignaturaRepo.findById(idAsig).orElseThrow(()->new Exception("Id no encontrado de asignatura"));
            student.getStudent_asignatura().add(student_asignatura);
        }
        studentRepo.save(student);
    }

    @Override
    public void desasignAsig(int idStudent, Map<String, Integer> mapaAsig) throws Exception {
        Student_Asignatura student_asignatura=null;
        Student student=studentRepo.findById(idStudent).orElseThrow(()->new Exception(""));
        for (Integer idAsig: mapaAsig.values()) {
            student_asignatura=asignaturaRepo.findById(idAsig).orElseThrow(()->new Exception("Id no encontrado de asignatura"));
            student.getStudent_asignatura().remove(student_asignatura);
        }
        studentRepo.save(student);
    }
}
