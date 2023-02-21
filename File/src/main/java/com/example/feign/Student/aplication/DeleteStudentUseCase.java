package com.example.feign.Student.aplication;

import com.example.feign.Student.aplication.port.DeleteStudentPort;
import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
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
