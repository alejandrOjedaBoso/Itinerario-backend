package com.example.Ejercicio11.infrastucture.controller.dto.output;

import com.example.Ejercicio11.domain.Persona;
import lombok.Data;
import java.util.Date;

public record PersonaOutputDTO(int idPersona,String password,String name,String surname,String companyEmail,String personalEmail,String city,
                              boolean active,Date createdDate,String imageUrl,Date teminationDate) {
    /*
    private int id_persona;
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
    */
    public PersonaOutputDTO(Persona persona) throws Exception {
        this(persona.getId_persona(), persona.getPassword(), persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(), persona.getCity(), persona.isActive(), persona.getCreated_date(), persona.getImagen_url(), persona.getCreated_date());
    }

}
