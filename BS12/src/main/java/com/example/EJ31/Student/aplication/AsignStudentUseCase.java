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

import java.util.ArrayList;
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
        persona.setStudent(student);

        studentRepo.save(student);
        personaRepo.save(persona);
    }

    @Override
    public void asignProfesorId(int idStudent, int idProfesor) throws Exception {
        Student student=studentRepo.findById(idStudent).orElseThrow(()->new Exception("No se ha encontrado el id: "+idStudent+" para el estudiante"));
        Profesor profesor=profesorRepo.findById(idProfesor).orElseThrow(()->new Exception("No se ha encontrado el id: "+idProfesor+" para el profesor"));

        if(profesor.getStudent()==null){
            profesor.setStudent(new ArrayList<Student>());
        }

        profesor.getStudent().add(student);
        student.setProfesor(profesor);

        studentRepo.save(student);
        profesorRepo.save(profesor);
    }

    @Override
    public void asignAsig(int idStudent, int asig) throws Exception {
        Student_Asignatura student_asignatura=asignaturaRepo.findById(asig).orElseThrow(()->new Exception("No se ha encontrado el id: "+asig+" para la asignatura"));
        Student student= studentRepo.findById(idStudent).orElseThrow(()->new Exception("No se ha encontrado el id: "+idStudent+" para el estuduante"));

        if (student.getStudent_asignatura()==null){
            student.setStudent_asignatura(new ArrayList<Student_Asignatura>());
        }
        if(student_asignatura.getStudent()==null){
            student_asignatura.setStudent(new ArrayList<Student>());
        }

        student_asignatura.getStudent().add(student);
        student.getStudent_asignatura().add(student_asignatura);

        asignaturaRepo.saveAndFlush(student_asignatura);
        studentRepo.saveAndFlush(student);
    }

    @Override
    public void desasignAsig(int idStudent, int asig) throws Exception {
        Student_Asignatura student_asignatura=asignaturaRepo.findById(asig).orElseThrow(()->new Exception("No se ha encontrado el id: "+asig+" para la asignatura"));
        Student student= studentRepo.findById(idStudent).orElseThrow(()->new Exception("No se ha encontrado el id: "+idStudent+" para el estuduante"));

        if (student.getStudent_asignatura()!=null && student.getStudent_asignatura().contains(student_asignatura)) {
            student.getStudent_asignatura().remove(student_asignatura);
            studentRepo.saveAndFlush(student);
        }
        if(student_asignatura.getStudent()!=null && student_asignatura.getStudent().contains(student)){
            student_asignatura.getStudent().remove(student);
            asignaturaRepo.saveAndFlush(student_asignatura);
        }
    }
}
