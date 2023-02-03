package com.example.EJ31.Profesor.aplication;

import com.example.EJ31.Profesor.aplication.port.AddProfesorPort;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProfesorUseCase implements AddProfesorPort {
@Autowired
    ProfesorRepo profesorRepo;
    @Override
    public Profesor addProfesor(Profesor profesor) {
        profesorRepo.save(profesor);
        return profesor;
    }
}
