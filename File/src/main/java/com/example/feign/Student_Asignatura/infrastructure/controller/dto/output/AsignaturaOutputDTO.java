package com.example.feign.Student_Asignatura.infrastructure.controller.dto.output;

import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import lombok.Data;

import java.util.Date;
@Data
public class AsignaturaOutputDTO {
    private int id_study;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;

    public AsignaturaOutputDTO(Student_Asignatura student_asignatura){
        setId_study(student_asignatura.getId_study());
        setAsignatura(student_asignatura.getAsignatura());
        setComment(student_asignatura.getComment());
        setFinish_date(student_asignatura.getFinish_date());
        setInitial_date(student_asignatura.getInitial_date());
    }
    public AsignaturaOutputDTO(){}
}
