package com.example.feign.Student.aplication.port;

import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.controller.dto.input.StudentInputDTO;

public interface UpdateStudentPort {
    public Student updateStudent(int id, StudentInputDTO studentInputDTO) throws Exception;
}
