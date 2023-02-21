package com.example.feign.Student.aplication.port;

import com.example.feign.Student.infrastructure.controller.dto.output.StudentOutputDTO;

public interface GetStudentPort {
    public StudentOutputDTO getSimpleStudent(int id) throws Exception;
    public StudentOutputDTO getFullStudent(int id) throws Exception;
}
