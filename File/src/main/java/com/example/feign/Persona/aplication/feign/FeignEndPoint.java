package com.example.feign.Persona.aplication.feign;

import com.example.feign.Profesor.aplication.port.GetProfesorPort;
import com.example.feign.Profesor.domain.Profesor;
import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.feign.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignEndPoint implements MyFeign{
    @Autowired
    GetProfesorPort getProfesorPort;
    @Override
    public ProfesorOutputDTO getIdFeign(int id) throws Exception {
        return getProfesorPort.getProfesor(id);
    }
}
