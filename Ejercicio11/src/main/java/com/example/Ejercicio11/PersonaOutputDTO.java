package com.example.Ejercicio11;

import lombok.Data;
import java.util.Date;

@Data
public class PersonaOutputDTO {
    private long id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public PersonaOutputDTO(Persona persona) throws Exception {
        setId_persona(persona.getId_persona());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());
        if(usuario==null){
            throw new Exception("Usuario no puede ser nulo");
        }
        if(password==null){
            throw new Exception("Password no puede ser nulo");
        }
        if(name==null){
            throw new Exception("Name no puede ser nulo");
        }
        if(company_email==null){
            throw new Exception("Company email no puede ser nulo");
        }
        if(personal_email==null){
            throw new Exception("Personal email no puede ser nulo");
        }
        if(city==null){
            throw new Exception("City no puede ser nulo");
        }
        if(created_date==null){
            throw new Exception("Created date no puede ser nulo");
        }
    }
}
