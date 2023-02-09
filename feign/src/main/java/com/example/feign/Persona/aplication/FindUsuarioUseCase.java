package com.example.feign.Persona.aplication;

import com.example.feign.Persona.aplication.port.FindUsuarioPort;
import com.example.feign.Persona.domain.Persona;
import com.example.feign.Persona.domain.ePersona;
import com.example.feign.Persona.infrastucture.controller.dto.output.PersonaFullOutPutDTO;
import com.example.feign.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.feign.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.feign.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import com.example.feign.Student.infrastructure.repository.jpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindUsuarioUseCase implements FindUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ProfesorRepo profesorRepo;
    @Override
    public List<PersonaOutputDTO> todasPersonas(String outputType) throws Exception {
        ArrayList<PersonaOutputDTO> listaDeSalida=new ArrayList<PersonaOutputDTO>();

        for (Persona p:personaRepo.findAll()) {
                listaDeSalida.add(new PersonaOutputDTO(p));
        }
        return listaDeSalida;
    }
    @Override
    public PersonaOutputDTO buscarPorId(int id, String outputType) throws Exception {
        Persona persona=personaRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        PersonaOutputDTO personaOutputDTO;


        //Compruebo si es alumno o profesor y a la vez es full, si no es ninguno de los dos solo devuelve la persona
        if(persona.getProfesor()!=null && outputType.equalsIgnoreCase("full")){
            personaOutputDTO=new PersonaFullOutPutDTO(persona, ePersona.PROFESOR);
        }else if(persona.getStudent()!=null && outputType.equalsIgnoreCase("full")){
            personaOutputDTO=new PersonaFullOutPutDTO(persona, ePersona.ESTUDIANTE);
        }else{
            personaOutputDTO=new PersonaOutputDTO(persona);
        }

        return personaOutputDTO;
    }
    @Override
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre,String outputType) throws Exception {
        ArrayList<PersonaOutputDTO> listaSalida = new ArrayList<>();
        for (Persona p: personaRepo.findByName(nombre)) {
            if(p.getProfesor()!=null && outputType.equalsIgnoreCase("full")){
                listaSalida.add(new PersonaFullOutPutDTO(p, ePersona.PROFESOR));
            }else if(p.getStudent()!=null && outputType.equalsIgnoreCase("full")){
                listaSalida.add(new PersonaFullOutPutDTO(p, ePersona.ESTUDIANTE));
            }else{
                listaSalida.add(new PersonaOutputDTO(p));
            }
        }
        return listaSalida;
    }
}
