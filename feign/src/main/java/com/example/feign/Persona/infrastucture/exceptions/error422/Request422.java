package com.example.feign.Persona.infrastucture.exceptions.error422;

public class Request422 extends RuntimeException{
    public Request422(String message) {
        super(message);
    }
}
