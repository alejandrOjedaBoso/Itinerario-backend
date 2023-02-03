package com.example.Ejercicio11.application;

import com.example.Ejercicio11.application.port.DeleteUsuarioPort;
import com.example.Ejercicio11.domain.Persona;
import com.example.Ejercicio11.infrastucture.repository.jpa.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@Service
public class DeleteUsuarioUseCase implements DeleteUsuarioPort {
    @Autowired
    PersonaRepo personaRepo;
    @Override
    public void borrarUsu(int id) throws Exception {
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
            personaRepo.delete(per);
        }
    }
}
