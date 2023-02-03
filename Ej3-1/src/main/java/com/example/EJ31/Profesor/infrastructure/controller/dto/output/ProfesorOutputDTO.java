package com.example.EJ31.Profesor.infrastructure.controller.dto.output;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import lombok.Data;

import java.util.List;

@Data
public class ProfesorOutputDTO {
    private int id_pofesor;
    private String coments;
    private String branch;
    private Persona persona;
    private List<Student> student;
    private List<Student_Asignatura> asignaturas;
    public ProfesorOutputDTO(){
    }
    public ProfesorOutputDTO(Profesor profesor){
        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
        setId_pofesor(profesor.getId_pofesor());
    }
}
