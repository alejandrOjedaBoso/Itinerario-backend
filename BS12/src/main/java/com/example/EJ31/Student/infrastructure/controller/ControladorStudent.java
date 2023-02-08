package com.example.EJ31.Student.infrastructure.controller;

import com.example.EJ31.Student.aplication.port.*;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.EJ31.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import com.example.EJ31.Student_Asignatura.domain.Student_Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class ControladorStudent {
    @Autowired
    AddStudentPort addStudentPort;
    @Autowired
    DeleteStudentPort deleteStudentPort;
    @Autowired
    UpdateStudentPort updateStudentPort;

    @Autowired
    GetStudentPort getStudentPort;
    @Autowired
    AsignStudentPort asignStudentPort;

    @PostMapping("/add")
    public StudentOutputDTO addStudent(@RequestBody StudentInputDTO studentInputDTO) throws Exception {
        Student student=new Student(studentInputDTO);
        StudentOutputDTO studentOutputDTO= new StudentOutputDTO(addStudentPort.addStudent(student));
        return studentOutputDTO;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) throws Exception {
        deleteStudentPort.deleteStudent(id);
    }
    @PutMapping("/update/{id}")
    public StudentOutputDTO updateStudent(@PathVariable int id, @RequestBody StudentInputDTO studentInputDTO) throws Exception {
        return new StudentOutputDTO(updateStudentPort.updateStudent(id,studentInputDTO));
    }
    @GetMapping("/get/{id}")
    public StudentOutputDTO getStudent(@PathVariable int id,@RequestParam(name = "outputType",defaultValue = "simple") String outputType) throws Exception {
        StudentOutputDTO studentOutputDTO=null;
        if(outputType.equalsIgnoreCase("full")){
            studentOutputDTO= getStudentPort.getFullStudent(id);
        }
        else{
            studentOutputDTO= getStudentPort.getSimpleStudent(id);
        }
        return studentOutputDTO;
    }
    @PutMapping("/asignar/persona/{idStudent}/{idPersona}")
    public void asignPersona(@PathVariable int idStudent, @PathVariable int idPersona) throws Exception {
        asignStudentPort.asignPersonaId(idStudent,idPersona);
    }
    @PutMapping("/asignar/profesor/{idStudent}/{idProfesor}")
    public void asignProfesor(@PathVariable int idStudent, @PathVariable int idProfesor) throws Exception {
        asignStudentPort.asignProfesorId(idStudent,idProfesor);
    }
    @PutMapping("/asignar/asignatura/{idStudent}/{idAsignatura}")
    public void asignAsig(@PathVariable int idStudent, @PathVariable int idAsignatura) throws Exception {
        asignStudentPort.asignAsig(idStudent,idAsignatura);
    }
    @PutMapping("/desasignar/asignatura/{idStudent}/{idAsignatura}")
    public void desasignAsig(@PathVariable int idStudent, @PathVariable int idAsignatura) throws Exception {
        asignStudentPort.desasignAsig(idStudent,idAsignatura);
    }
}
