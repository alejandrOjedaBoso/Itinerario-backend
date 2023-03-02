package com.example.EJ31.Profesor.aplication;

import com.example.EJ31.Profesor.aplication.port.UpdateProfesorPort;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfesorUseCase implements UpdateProfesorPort {
    @Autowired
    ProfesorRepo profesorRepo;
    @Override
    public ProfesorOutputDTO updateProfesor(int id, ProfesorInputDTO profesorInputDTO) throws Exception {
        Profesor profesor=profesorRepo.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el id: "+id));

        profesor.setBranch(profesorInputDTO.getBranch());
        profesor.setComents(profesorInputDTO.getComents());
        profesor.setId_pofesor(id);
        profesorRepo.save(profesor);

        return new ProfesorOutputDTO(profesor);
    }
}
