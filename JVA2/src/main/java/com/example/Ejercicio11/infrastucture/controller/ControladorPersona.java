package com.example.Ejercicio11.infrastucture.controller;

import com.example.Ejercicio11.application.port.AddUsuarioPort;
import com.example.Ejercicio11.application.port.DeleteUsuarioPort;
import com.example.Ejercicio11.application.port.UpdateUsuarioPort;
import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.Ejercicio11.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.Ejercicio11.application.port.FindUsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorPersona {
    @Autowired
    AddUsuarioPort addUsuario;
    @Autowired
    DeleteUsuarioPort deleteUsuario;
    @Autowired
    UpdateUsuarioPort updateUsuario;
    @Autowired
    FindUsuarioPort findUsuario;

    @PostMapping("/addPersona")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO persona) throws Exception{
        return addUsuario.aniadirUsuario(persona);
    }
    @GetMapping("/id/{id}")
    public PersonaOutputDTO getId(@PathVariable Integer id) throws Exception{
        return findUsuario.buscarPorId(id);
    }
    @GetMapping("/name/{name}")
    public ArrayList<PersonaOutputDTO> getNombre(@PathVariable String name) throws Exception {
        return findUsuario.buscarPorNombre(name);
    }
    @GetMapping("/getall")
    public List<PersonaOutputDTO> getAll() throws Exception{
        return findUsuario.todasPersonas();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUsu(@PathVariable int id) throws Exception {
        deleteUsuario.borrarUsu(id);
    }
    @PutMapping("/modificar/{id}")
    public PersonaOutputDTO updateUsu(@PathVariable int id,@RequestBody PersonaInputDTO persona) throws Exception {
        return updateUsuario.modificarPersona(id,persona);
    }
}
