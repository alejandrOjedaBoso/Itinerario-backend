package com.example.feign.Student.infrastructure.controller.dto.output;

import com.example.feign.Student.domain.Student;
import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import com.example.feign.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentOutputDTO {
    private int id_student;
    private int num_hours_week;
    private String coments;
    private String branch;
    private List<AsignaturaOutputDTO> asignaturas;

    public StudentOutputDTO(){}
    public StudentOutputDTO(Student student){
        setId_student(student.getId_student());
        setNum_hours_week(student.getNum_hours_week());
        setComents(student.getComents());
        setBranch(student.getBranch());

        if(student.getStudent_asignatura()!=null) {
            List<AsignaturaOutputDTO> datitos = new ArrayList<AsignaturaOutputDTO>();
            setAsignaturas(datitos);
            for (Student_Asignatura a : student.getStudent_asignatura()) {
                datitos.add(new AsignaturaOutputDTO(a));
            }
        }
    }
}
