package com.example.feign.Persona.aplication;

import com.example.feign.Persona.aplication.port.DeleteUsuarioPort;
import com.example.feign.Persona.infrastucture.exceptions.error404.Request404;
import com.example.feign.Persona.domain.Persona;
import com.example.feign.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.feign.Profesor.domain.Profesor;
import com.example.feign.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import com.example.feign.Student.domain.Student;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUsuarioUseCase implements DeleteUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Autowired
    ProfesorRepo profesorRepo;
    @Autowired
    StudentRepo studentRepo;
    @Override
    public void borrarUsu(int id) throws Exception {
        Persona per = personaRepo.findById(id).orElseThrow(()->new Request404("No se ha encontrado el id de la persona"));
        boolean borrar=true;

        for (Student i:studentRepo.findAll()) {
            if (id==i.getPersona().getId_persona()){
                borrar=false;
                throw new Request404("Es un estudiante, no se ha podido borrar");
            }
        }
        for (Profesor p:profesorRepo.findAll()) {
            if(id==p.getPersona().getId_persona()){
                borrar=false;
                throw new Request404("Es un profesor, no se ha podido borrar");
            }
        }
        if (borrar) {
            personaRepo.delete(per);
        }
    }
}
