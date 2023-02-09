package com.example.feign.Profesor.aplication;

import com.example.feign.Profesor.aplication.port.GetProfesorPort;
import com.example.feign.Profesor.domain.Profesor;
import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.feign.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProfesorUseCase implements GetProfesorPort {
    @Autowired
    ProfesorRepo profesorRepo;
    @Override
    public ProfesorOutputDTO getProfesor(int id) throws Exception {
        Profesor profesor=profesorRepo.findById(id).orElseThrow(()->new Exception("No se ha encontrado el id: "+id));
        return new ProfesorOutputDTO(profesor);
    }
}
