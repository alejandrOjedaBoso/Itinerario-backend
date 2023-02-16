package com.example.feign.Profesor.domain;

import com.example.feign.Persona.domain.Persona;
import com.example.feign.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.feign.Student.domain.Student;
import com.example.feign.Student_Asignatura.domain.Student_Asignatura;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private int id_pofesor;

    @Column(name = "coments")
    private String coments;

    @Column(name = "branch")
    private String branch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @OneToMany(mappedBy = "profesor",fetch = FetchType.LAZY)
    private List<Student> student;

    @OneToMany(mappedBy = "profesor",cascade = CascadeType.ALL)
    private List<Student_Asignatura> asignaturas;
    public Profesor(){}
    public Profesor(ProfesorInputDTO profesorInputDTO){
        setBranch(profesorInputDTO.getBranch());
        setComents(profesorInputDTO.getComents());
        setId_pofesor(profesorInputDTO.getId_pofesor());
    }

}
