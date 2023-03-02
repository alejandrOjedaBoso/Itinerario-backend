package com.example.EJ31.Profesor.aplication;

import com.example.EJ31.Profesor.aplication.port.DeleteProfesorPort;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUseCase implements DeleteProfesorPort {
    @Autowired
    ProfesorRepo profesorRepo;

    @Override
    public void deleteProfesor(int id) throws Exception {
        Profesor profesor=profesorRepo.findById(id).orElseThrow(()-> new Exception("No se ha encontrado el profesor con el id: "+id));
        profesorRepo.delete(profesor);
    }
}
