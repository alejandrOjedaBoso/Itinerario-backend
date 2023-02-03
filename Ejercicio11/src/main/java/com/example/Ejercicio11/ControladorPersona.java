package com.example.Ejercicio11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorPersona {
    @Autowired
    PersonaService personaService;

    @PostMapping("/addPersona")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO persona) throws Exception{
        return personaService.aniadirUsuario(persona);
    }
    @GetMapping("/id/{id}")
    public PersonaOutputDTO getId(@PathVariable Integer id) throws Exception{
        return personaService.buscarPorId(id);
    }
    @GetMapping("/name/{name}")
    public PersonaOutputDTO getUsuario(@PathVariable String name) throws Exception {
        return personaService.buscarPorUsuario(name);
    }
    @GetMapping("/getall")
    public List<PersonaOutputDTO> getAll() throws Exception{
        return personaService.todasPersonas();
    }
    @DeleteMapping("/delete/{id}")
    public PersonaOutputDTO deleteUsu(@PathVariable int id) throws Exception {
        return personaService.borrarUsu(id);
    }
    @PutMapping("/modificar/{id}")
    public PersonaOutputDTO updateUsu(@PathVariable int id,@RequestBody PersonaInputDTO persona) throws Exception {
        return personaService.modificarPersona(id,persona);
    }
}
