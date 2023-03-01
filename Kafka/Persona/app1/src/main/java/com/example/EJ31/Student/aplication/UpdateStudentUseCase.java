package com.example.EJ31.Student.aplication;

import com.example.EJ31.Student.aplication.port.UpdateStudentPort;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student updateStudent(int id, StudentInputDTO studentInputDTO) throws Exception {
        Student student=studentRepo.findById(id).orElseThrow(()->new Exception("No se encuentra el id: "+id));

        student.setId_student(id);
        student.setBranch(studentInputDTO.getBranch());
        student.setComents(studentInputDTO.getComents());
        student.setNum_hours_week(studentInputDTO.getNum_hours_week());

        studentRepo.save(student);
        return student;
    }
}
