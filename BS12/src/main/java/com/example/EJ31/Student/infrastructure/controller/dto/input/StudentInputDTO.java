package com.example.EJ31.Student.infrastructure.controller.dto.input;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Profesor.domain.Profesor;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class StudentInputDTO {
    private int id_student;
    private int num_hours_week;
    private String coments;
    private String branch;
}
