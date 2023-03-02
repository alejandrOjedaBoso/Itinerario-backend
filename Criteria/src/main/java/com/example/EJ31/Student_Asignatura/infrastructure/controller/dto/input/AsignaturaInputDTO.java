package com.example.EJ31.Student_Asignatura.infrastructure.controller.dto.input;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class AsignaturaInputDTO {
    private int id_study;
    private String asignatura;
    private String comment;
    private Date initial_date;
    private Date finish_date;
}
