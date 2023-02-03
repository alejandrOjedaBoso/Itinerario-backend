package com.example.Ejercicio11.infrastucture.exceptions.error404;

public class Request404 extends RuntimeException{
    public Request404(String message) {
        super(message);
    }
}
