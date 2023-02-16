package com.example.feign.Student.infrastructure.controller.dto.input;

import lombok.Data;

import jakarta.persistence.*;

@Data
public class StudentInputDTO {
    private int id_student;
    private int num_hours_week;
    private String coments;
    private String branch;
}
