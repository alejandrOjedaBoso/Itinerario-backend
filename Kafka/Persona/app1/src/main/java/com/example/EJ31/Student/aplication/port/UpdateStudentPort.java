package com.example.EJ31.Student.aplication.port;

import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.controller.dto.input.StudentInputDTO;

public interface UpdateStudentPort {
    public Student updateStudent(int id, StudentInputDTO studentInputDTO) throws Exception;
}
