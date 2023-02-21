package com.example.feign.Student.aplication;

import com.example.feign.Persona.domain.Persona;
import com.example.feign.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.feign.Student.aplication.port.GetStudentPort;
import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.controller.dto.output.StudentFullOutputDTO;
import com.example.feign.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getStudentUseCase implements GetStudentPort {
    @Autowired
    PersonaRepo personaRepo;

    @Autowired
    StudentRepo studentRepo;

    @Override
    public StudentOutputDTO getSimpleStudent(int id) throws Exception {
        Student student= studentRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado ID: "+id+" en estudiante"));
        StudentOutputDTO studentOutputDTO= new StudentOutputDTO();
        studentOutputDTO.setId_student(student.getId_student());
        studentOutputDTO.setBranch(student.getBranch());
        studentOutputDTO.setComents(student.getComents());
        studentOutputDTO.setNum_hours_week(student.getNum_hours_week());

        return studentOutputDTO;
    }

    @Override
    public StudentOutputDTO getFullStudent(int id) throws Exception {
        Student student= studentRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado ID: "+id+" en estudiante"));
        Student ayuda=new Student();
        ayuda.setId_student(student.getId_student());
        ayuda.setBranch(student.getBranch());
        ayuda.setComents(student.getComents());
        ayuda.setNum_hours_week(student.getNum_hours_week());

        Persona persona=personaRepo.findById(student.getPersona().getId_persona()).orElseThrow(()-> new Exception(""));
        Persona aux=new Persona();
        aux.setId_persona(persona.getId_persona());
        aux.setUsuario(persona.getUsuario());
        aux.setPassword(persona.getPassword());
        aux.setName(persona.getName());
        aux.setSurname(persona.getSurname());
        aux.setCompany_email(persona.getCompany_email());
        aux.setPersonal_email(persona.getPersonal_email());
        aux.setCity(persona.getCity());
        aux.setActive(persona.isActive());
        aux.setCreated_date(persona.getCreated_date());
        aux.setImagen_url(persona.getImagen_url());
        aux.setTermination_date(persona.getTermination_date());
        StudentFullOutputDTO studentFullOutputDTO= new StudentFullOutputDTO(ayuda,aux);

        return studentFullOutputDTO;
    }
}
