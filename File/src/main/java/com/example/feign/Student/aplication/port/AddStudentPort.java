package com.example.feign.Student.aplication.port;

import com.example.feign.Student.domain.Student;


public interface AddStudentPort {
    public Student addStudent(Student student) throws Exception;
}
