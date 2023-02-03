package com.example.EJ31.Persona.aplication;

import com.example.EJ31.Persona.aplication.port.FeignPort;
import com.example.EJ31.Profesor.aplication.port.GetProfesorPort;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeignUseCase implements FeignPort {
    @Autowired
    GetProfesorPort getProfesorPort;

    @Override
    public ResponseEntity<ProfesorOutputDTO> callServer(int id) throws Exception {
        return ResponseEntity.ok(getProfesorPort.getProfesor(id));
    }
}
