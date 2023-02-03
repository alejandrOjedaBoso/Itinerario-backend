package com.example.Ejercicio11.infrastucture.exceptions;

import com.example.Ejercicio11.infrastucture.exceptions.error404.Request404;
import com.example.Ejercicio11.infrastucture.exceptions.error422.Request422;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class HandlerExcepciones {
    @ExceptionHandler(Request404.class)
    public ResponseEntity<Object> handlerError(Request404 request404) {
        CustomError customError = new CustomError(new Date(), 404, request404.getMessage());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Request422.class)
    public ResponseEntity<Object> handlerError(Request422 request422) {
        CustomError customError = new CustomError(new Date(), 422, request422.getMessage());
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
