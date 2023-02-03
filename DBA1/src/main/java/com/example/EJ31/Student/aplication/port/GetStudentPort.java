package com.example.EJ31.Student.aplication.port;

import com.example.EJ31.Student.infrastructure.controller.dto.output.StudentOutputDTO;

public interface GetStudentPort {
    public StudentOutputDTO getSimpleStudent(int id) throws Exception;
    public StudentOutputDTO getFullStudent(int id) throws Exception;
}
