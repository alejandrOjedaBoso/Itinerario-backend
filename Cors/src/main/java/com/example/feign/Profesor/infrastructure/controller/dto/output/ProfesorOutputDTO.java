package com.example.feign.Profesor.infrastructure.controller.dto.output;

import com.example.feign.Profesor.domain.Profesor;
import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfesorOutputDTO {
    private int id_pofesor;
    private String coments;
    private String branch;
    private List<StudentOutputDTO> student;
    public ProfesorOutputDTO(){
    }
    public ProfesorOutputDTO(Profesor profesor){
        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
        setId_pofesor(profesor.getId_pofesor());

        if (profesor.getStudent()!=null) {
            List<StudentOutputDTO> datitos = new ArrayList<StudentOutputDTO>();
            setStudent(datitos);
            for (Student s : profesor.getStudent()) {
                datitos.add(new StudentOutputDTO(s));
            }
        }
    }
}
