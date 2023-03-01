package com.example.EJ31.Student.domain;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Student.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import lombok.Data;

import javax.persistence.*;

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
