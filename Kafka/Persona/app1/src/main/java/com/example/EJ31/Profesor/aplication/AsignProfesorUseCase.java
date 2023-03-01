package com.example.EJ31.Profesor.aplication;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.EJ31.Profesor.aplication.port.AsignProfesorPort;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignProfesorUseCase implements AsignProfesorPort {
    @Autowired
    ProfesorRepo profesorRepo;
    @Autowired
    PersonaRepo personaRepo;
    @Override
    public void asignPersonaId(int idProfesor, int idPersona) throws Exception {
        Profesor profesor=profesorRepo.findById(idProfesor).orElseThrow(()->new Exception("El id de profesor no coincide"));
        Persona persona=personaRepo.findById(idPersona).orElseThrow(()-> new Exception("El id de persona no coincide"));
        profesor.setPersona(persona);
        persona.setProfesor(profesor);
        profesorRepo.save(profesor);
        personaRepo.save(persona);
    }
}
