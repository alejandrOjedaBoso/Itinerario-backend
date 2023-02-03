package com.example.EJ31.Persona.infrastucture.exceptions;

import java.util.Date;

public class CustomError {
    private Date timestamp;
    private int HttpCode;
    private String message;

    public CustomError(Date timestamp, int httpCode, String message) {
        super();
        this.timestamp = timestamp;
        HttpCode = httpCode;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getHttpCode() {
        return HttpCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CustomError{" +
                "timestamp=" + timestamp +
                ", HttpCode=" + HttpCode +
                ", message='" + message + '\'' +
                '}';
    }
}
