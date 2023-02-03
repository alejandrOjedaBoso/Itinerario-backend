package com.example.EJ31.Persona.aplication;

import com.example.EJ31.Persona.aplication.port.DeleteUsuarioPort;
import com.example.EJ31.Persona.infrastucture.exceptions.error404.Request404;
import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteUsuarioUseCase implements DeleteUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Override
    public void borrarUsu(int id) throws Exception {
        Persona per = personaRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado el id de la persona"));
        boolean borrar=true;
        ArrayList<Student> students=null;
        ArrayList<Profesor> profesors=null;
        for (Student i:students) {
            if (id==i.getPersona().getId_persona()){
                borrar=false;
            }
        }
        for (Profesor p:profesors) {
            if(id==p.getPersona().getId_persona()){
                borrar=false;
            }
        }
        if (borrar) {
            personaRepo.delete(per);
        }
    }
}
