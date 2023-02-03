package com.example.EJ31.Student.aplication;

import com.example.EJ31.Student.aplication.port.DeleteStudentPort;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCase implements DeleteStudentPort{
    @Autowired
    StudentRepo studentRepo;

    @Override
    public void deleteStudent(int id) throws Exception{
        Student student=studentRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado el id: "+id));

        studentRepo.delete(student);
    }
}
