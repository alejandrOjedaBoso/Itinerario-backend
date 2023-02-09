package com.example.feign.Student.domain;

import com.example.feign.Persona.domain.Persona;
import com.example.feign.Profesor.domain.Profesor;
import com.example.feign.Student.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id_student;

    @Column(name = "num_hours_week")
    private int num_hours_week;

    @Column(name = "coments")
    private String coments;

    @Column(name = "branch")
    private String branch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Student_Asignatura> student_asignatura;

    public Student(StudentInputDTO studentInputDTO){
              setId_student(studentInputDTO.getId_student());
              setNum_hours_week(studentInputDTO.getNum_hours_week());
              setComents(studentInputDTO.getComents());
              setBranch(studentInputDTO.getBranch());
    }
    public Student(){
    }
}
