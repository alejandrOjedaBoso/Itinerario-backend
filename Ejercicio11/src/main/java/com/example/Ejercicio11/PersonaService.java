package com.example.Ejercicio11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaService {
    @Autowired
    PersonaRepo personaRepo;

    public PersonaOutputDTO aniadirUsuario(PersonaInputDTO persona) throws Exception {
        if(persona.getUsuario().length()<6 || persona.getUsuario().length()>10){
            throw new Exception("El usuario debe estar entre 6 y 10 caracteres");
        }
        else {
            Persona entidad=new Persona(persona);
            personaRepo.save(entidad);
            return new PersonaOutputDTO(entidad);
        }
    }

    public List<PersonaOutputDTO> todasPersonas() throws Exception {
        List<Persona> listaPersona=personaRepo.findAll();
        List<PersonaOutputDTO> listaDTO= new ArrayList<PersonaOutputDTO>();
        for (Persona per: listaPersona) {
            listaDTO.add(new PersonaOutputDTO(per));
        }
        return listaDTO;
    }

    public PersonaOutputDTO buscarPorId(Integer id) throws Exception {
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
            throw new Exception("No existe el id");
        }
        else{
            return new PersonaOutputDTO(per);
        }
    }

    public PersonaOutputDTO buscarPorUsuario(String usuario) throws Exception {
        List<Persona> listaPersona= personaRepo.findAll();
        Persona per = null;
        boolean salir=false;
        for (int i = 0; i < listaPersona.size() && salir==false; i++) {
            if(listaPersona.get(i).getUsuario().equalsIgnoreCase(usuario)){
                per=listaPersona.get(i);
                salir=true;
            }
        }
        if(per==null){
            throw new Exception("No existe el Usuario");
        }
        else{
            return new PersonaOutputDTO(per);
        }
    }
    public PersonaOutputDTO borrarUsu(int id) throws Exception {
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
            throw new Exception("No existe el id");
        }
        else{
            personaRepo.delete(per);
            return new PersonaOutputDTO(per);
        }
    }
    public PersonaOutputDTO modificarPersona(int id,PersonaInputDTO personaDTO) throws Exception {
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
            throw new Exception("No existe el id");
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
