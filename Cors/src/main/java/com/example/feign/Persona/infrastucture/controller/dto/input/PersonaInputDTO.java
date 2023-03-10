package com.example.feign.Persona.infrastucture.controller.dto.input;

import lombok.Data;


import java.util.Date;

@Data
public class PersonaInputDTO {
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

}
