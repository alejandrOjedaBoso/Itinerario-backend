package com.example.feign.Persona.infrastucture.controller;

import com.example.feign.Persona.aplication.feign.MyFeign;
import com.example.feign.Persona.aplication.port.AddUsuarioPort;
import com.example.feign.Persona.aplication.port.DeleteUsuarioPort;
import com.example.feign.Persona.aplication.port.UpdateUsuarioPort;
import com.example.feign.Persona.aplication.port.FindUsuarioPort;
import com.example.feign.Persona.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.feign.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.feign.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/persona")
public class ControladorPersona {
    @Autowired
    AddUsuarioPort addUsuario;
    @Autowired
    DeleteUsuarioPort deleteUsuario;
    @Autowired
    UpdateUsuarioPort updateUsuario;
    @Autowired
    FindUsuarioPort findUsuario;
    @Autowired
    MyFeign myFeign;

    @CrossOrigin()
    @PostMapping("/addperson")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO persona) throws Exception{
        return addUsuario.aniadirUsuario(persona);
    }
    @GetMapping("/id/{id}")
    public PersonaOutputDTO getId(@PathVariable Integer id,@RequestParam(name = "outputType",defaultValue = "simple") String outputType) throws Exception{
        return findUsuario.buscarPorId(id,outputType);
    }
    @GetMapping("/name/{name}")
    public ArrayList<PersonaOutputDTO> getNombre(@PathVariable String name,@RequestParam(name = "outputType",defaultValue = "simple") String outputType) throws Exception {
        return findUsuario.buscarPorNombre(name,outputType);
    }
    @CrossOrigin()
    @GetMapping("/getall")
    public List<PersonaOutputDTO> getAll(@RequestParam(name = "outputType",defaultValue = "simple") String outputType) throws Exception{
        return findUsuario.todasPersonas(outputType);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUsu(@PathVariable int id) throws Exception {
        deleteUsuario.borrarUsu(id);
    }
    @PutMapping("/modificar/{id}")
    public PersonaOutputDTO updateUsu(@PathVariable int id,@RequestBody PersonaInputDTO persona) throws Exception {
        return updateUsuario.modificarPersona(id,persona);
    }

    @GetMapping("/profesor/{id}")
    public ProfesorOutputDTO getProfesorIdFeign(@PathVariable int id) throws Exception {
        return myFeign.getIdFeign(id);
    }
}
