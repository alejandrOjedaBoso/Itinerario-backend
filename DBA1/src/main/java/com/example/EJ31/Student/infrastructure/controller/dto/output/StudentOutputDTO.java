package com.example.EJ31.Student.infrastructure.controller.dto.output;

import com.example.EJ31.Student.domain.Student;
import lombok.Data;

@Data
public class StudentOutputDTO {
    private int id_student;
    private int num_hours_week;
    private String coments;
    private String branch;

    public StudentOutputDTO(){}
    public StudentOutputDTO(Student student){
        setId_student(student.getId_student());
        setNum_hours_week(student.getNum_hours_week());
        setComents(student.getComents());
        setBranch(student.getBranch());
    }
}
