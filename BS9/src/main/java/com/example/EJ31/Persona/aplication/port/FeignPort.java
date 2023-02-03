package com.example.EJ31.Persona.aplication.port;

import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@FeignClient(name ="Feign",url = "https://127.0.0.1:8080")
public interface FeignPort {
    ResponseEntity<ProfesorOutputDTO> callServer(int id) throws Exception;
}
