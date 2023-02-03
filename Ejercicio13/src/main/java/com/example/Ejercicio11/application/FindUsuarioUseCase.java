package com.example.Ejercicio11.application;

import com.example.Ejercicio11.application.port.FindUsuarioPort;
import com.example.Ejercicio11.domain.Persona;
import com.example.Ejercicio11.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.Ejercicio11.infrastucture.exceptions.error404.Request404;
import com.example.Ejercicio11.infrastucture.repository.jpa.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindUsuarioUseCase implements FindUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Override
    public List<PersonaOutputDTO> todasPersonas() throws Exception {
        List<Persona> listaPersona=personaRepo.findAll();
        List<PersonaOutputDTO> listaDTO= new ArrayList<PersonaOutputDTO>();
        for (Persona per: listaPersona) {
            listaDTO.add(new PersonaOutputDTO(per));
        }
        return listaDTO;
    }
    @Override
    public PersonaOutputDTO buscarPorId(int id) throws Exception {
        if(personaRepo.findById(id).isEmpty()){
            throw new Request404("No se ha encontrado");
        }
        Persona per = personaRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return new PersonaOutputDTO(per);
    }
    @Override
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre) throws Exception {
        List<Persona> listaPersona= personaRepo.findAll();
        ArrayList<PersonaOutputDTO> salidaDTO= new ArrayList<PersonaOutputDTO>();

        for (int i = 0; i < listaPersona.size(); i++) {
            if(listaPersona.get(i).getName().equalsIgnoreCase(nombre)){
                salidaDTO.add(new PersonaOutputDTO(listaPersona.get(i)));
            }
        }
        if(listaPersona.isEmpty()){
            throw new Exception("No existe el nombre");
        }
        else{
            return salidaDTO;
        }
    }
}
