package com.example.EJ31.Persona.infrastucture.controller;

import com.example.EJ31.Persona.aplication.port.AddUsuarioPort;
import com.example.EJ31.Persona.aplication.port.DeleteUsuarioPort;
import com.example.EJ31.Persona.aplication.port.UpdateUsuarioPort;
import com.example.EJ31.Persona.aplication.port.FindUsuarioPort;
import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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

    @CrossOrigin(origins = "https://codepen.io/de4imo/pen/VwMRENP")
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
    @CrossOrigin(origins = "https://codepen.io/de4imo/pen/VwMRENP")
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
    @GetMapping("/criteria")
    public ResponseEntity<List<Persona>> buscarCriteria(@RequestParam(required = false) String tipoDato, @RequestParam(required = false) String ordenar, @RequestBody HashMap<String, Object> datos,@RequestParam(required = false,defaultValue = "10") String tamano, @RequestParam(required = true) int numPag){
        return ResponseEntity.ok(findUsuario.criteriaEj1(datos,tipoDato,ordenar,Integer.parseInt(tamano),numPag));
    }
}
