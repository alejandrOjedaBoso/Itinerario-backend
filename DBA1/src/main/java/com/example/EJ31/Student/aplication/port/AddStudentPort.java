package com.example.EJ31.Student.aplication.port;

import com.example.EJ31.Student.domain.Student;


public interface AddStudentPort {
    public Student addStudent(Student student) throws Exception;
}
