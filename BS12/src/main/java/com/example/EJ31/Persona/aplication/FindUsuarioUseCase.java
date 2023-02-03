package com.example.EJ31.Persona.aplication;

import com.example.EJ31.Persona.aplication.port.FindUsuarioPort;
import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaFullOutPutDTO;
import com.example.EJ31.Persona.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.EJ31.Persona.infrastucture.exceptions.error404.Request404;
import com.example.EJ31.Persona.infrastucture.repository.jpa.PersonaRepo;
import com.example.EJ31.Profesor.domain.Profesor;
import com.example.EJ31.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.example.EJ31.Profesor.infrastructure.repository.jpa.ProfesorRepo;
import com.example.EJ31.Student.domain.Student;
import com.example.EJ31.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import com.example.EJ31.Student.infrastructure.repository.jpa.StudentRepo;
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
        List<Persona> listaPersona=personaRepo.findAll();
        List<PersonaOutputDTO> listaDTO= new ArrayList<PersonaOutputDTO>();
        PersonaOutputDTO personaOutputDTO=null;
        for (Persona per: listaPersona) {
            personaOutputDTO=tipoPersona(per);
            if(outputType.equalsIgnoreCase("full")&& personaOutputDTO!=null){
                listaDTO.add(personaOutputDTO);
            }else {
                personaOutputDTO=new PersonaOutputDTO(per);
                listaDTO.add(personaOutputDTO);
            }
        }
        return listaDTO;
    }
    @Override
    public PersonaOutputDTO buscarPorId(int id, String outputType) throws Exception {
        PersonaOutputDTO personaOutputDTO=null,aux=null;
        if(personaRepo.findById(id).isEmpty()){
            throw new Request404("No se ha encontrado");
        }
        Persona per = personaRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        personaOutputDTO=new PersonaOutputDTO(per);
        aux=tipoPersona(per);
        if (aux!=null && outputType.equalsIgnoreCase("full")){
            personaOutputDTO=aux;
        }
        return personaOutputDTO;
    }
    @Override
    public ArrayList<PersonaOutputDTO> buscarPorNombre(String nombre,String outputType) throws Exception {
        List<Persona> listaPersona= personaRepo.findAll();
        ArrayList<PersonaOutputDTO> salidaDTO= new ArrayList<PersonaOutputDTO>();
        PersonaOutputDTO personaOutputDTO=null;
        for (int i = 0; i < listaPersona.size(); i++) {
            if(listaPersona.get(i).getName().equalsIgnoreCase(nombre)){
                personaOutputDTO=tipoPersona(listaPersona.get(i));
                if (outputType.equalsIgnoreCase("full")&&personaOutputDTO!=null){
                    salidaDTO.add(personaOutputDTO);
                }else {
                    personaOutputDTO=new PersonaOutputDTO(listaPersona.get(i));
                    salidaDTO.add(personaOutputDTO);
                }
            }
        }
        if(listaPersona.isEmpty()){
            throw new Exception("No existe el nombre");
        }
        else{
            return salidaDTO;
        }
    }
    private PersonaOutputDTO tipoPersona(Persona per) throws Exception {
        List<Student> listaEstu=studentRepo.findAll();
        List<Profesor> listaProfesors=profesorRepo.findAll();
        PersonaOutputDTO devolver=null;
        Persona aux=null;

        for (Student i:listaEstu) {
            aux=i.getPersona();
            if(aux!=null) {
                if (i.getPersona().getId_persona() == per.getId_persona()) {
                    devolver = new PersonaFullOutPutDTO(per, new StudentOutputDTO(i));
                }
            }
        }
        for (Profesor i:listaProfesors) {
            aux=i.getPersona();
            if(aux!=null) {
                if (i.getPersona().getId_persona() == per.getId_persona()) {
                    devolver = new PersonaFullOutPutDTO(per, new ProfesorOutputDTO(i));
                }
            }
        }
        return devolver;
    }
}
