package com.example.Ejercicio11.application;

import com.example.Ejercicio11.application.port.UpdateUsuarioPort;
import com.example.Ejercicio11.infrastucture.controller.dto.input.PersonaInputDTO;
import com.example.Ejercicio11.infrastucture.controller.dto.output.PersonaOutputDTO;
import com.example.Ejercicio11.domain.Persona;
import com.example.Ejercicio11.infrastucture.repository.jpa.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UpdateUsuarioUseCase implements UpdateUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Override
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaDTO) throws Exception {
        List<Persona> listaPersona= personaRepo.findAll();
        Persona per = null;
        boolean salir=false;
        for (int i = 0; i < listaPersona.size() && salir==false; i++) {
            if(listaPersona.get(i).getId_persona()==(id)){
                per=listaPersona.get(i);
                salir=true;
            }
        }
        if(per==null){
            throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            per.setId_persona(id);
            per.setUsuario(personaDTO.getUsuario());
            per.setPassword(personaDTO.getPassword());
            per.setName(personaDTO.getName());
            per.setSurname(personaDTO.getSurname());
            per.setCompany_email(personaDTO.getCompany_email());
            per.setPersonal_email(personaDTO.getPersonal_email());
            per.setCity(personaDTO.getCity());
            per.setActive(personaDTO.isActive());
            per.setCreated_date(personaDTO.getCreated_date());
            per.setImagen_url(personaDTO.getImagen_url());
            per.setTermination_date(personaDTO.getTermination_date());
            personaRepo.saveAndFlush(per);
            return new PersonaOutputDTO(per);
        }
    }
}
