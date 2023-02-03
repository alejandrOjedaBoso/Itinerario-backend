package com.example.Ejercicio11.infrastucture.exceptions.error422;

public class Request422 extends RuntimeException{
    public Request422(String message) {
        super(message);
    }
}
