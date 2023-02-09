package com.example.feign.Persona.aplication.feign;

import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url="http://localhost:8081",name = "myFeign")
public interface MyFeign {
    @GetMapping("/profesor/get/{id}")
    ProfesorOutputDTO getIdFeign(@PathVariable int id) throws Exception;
}
