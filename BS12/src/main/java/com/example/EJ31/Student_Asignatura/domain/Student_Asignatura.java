package com.example.EJ31.Student_Asignatura.domain;

import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.input.AsignaturaInputDTO;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Estudios")
public class Student_Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private List<Student> student;

    @Column(name = "asignatura")
    private String asignatura;

    @Column(name = "comnent")
    private String comment;

    @Column(name = "initial_date")
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;

    public Student_Asignatura(AsignaturaInputDTO asignaturaInputDTO){
        setId_study(asignaturaInputDTO.getId_study());
        setAsignatura(asignaturaInputDTO.getAsignatura());
        setComment(asignaturaInputDTO.getComment());
        setFinish_date(asignaturaInputDTO.getFinish_date());
        setInitial_date(asignaturaInputDTO.getInitial_date());
    }
    public Student_Asignatura(){}
}
