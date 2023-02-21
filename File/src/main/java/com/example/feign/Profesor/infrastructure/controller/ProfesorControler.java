package com.example.feign.Profesor.infrastructure.controller;

import com.example.feign.Persona.aplication.feign.MyFeign;
import com.example.feign.Profesor.aplication.port.*;
import com.example.feign.Profesor.domain.Profesor;
import com.example.feign.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorControler {
    @Autowired
    AddProfesorPort addProfesorPort;
    @Autowired
    DeleteProfesorPort deleteProfesorPort;
    @Autowired
    UpdateProfesorPort updateProfesorPort;
    @Autowired
    GetProfesorPort getProfesorPort;
    @Autowired
    AsignProfesorPort asignProfesorPort;

    @PostMapping("/add")
    public ProfesorOutputDTO addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO){
        return new ProfesorOutputDTO(addProfesorPort.addProfesor(new Profesor(profesorInputDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfesor(@PathVariable int id) throws Exception {
        deleteProfesorPort.deleteProfesor(id);
    }

    @PutMapping("/update/{id}")
    public ProfesorOutputDTO updateProfesor(@PathVariable int id, @RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        return updateProfesorPort.updateProfesor(id,profesorInputDTO);
    }

    @GetMapping("/get/{id}")
    public ProfesorOutputDTO getProfesor(@PathVariable int id) throws Exception {
        return getProfesorPort.getProfesor(id);
    }

    @PutMapping("/asign/persona/{idProfesor}/{idPersona}")
    public void asignPersona(@PathVariable int idProfesor, @PathVariable int idPersona) throws Exception {
        asignProfesorPort.asignPersonaId(idProfesor,idPersona);
    }
}
